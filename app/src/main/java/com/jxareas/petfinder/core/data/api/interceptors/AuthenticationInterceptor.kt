package com.jxareas.petfinder.core.data.api.interceptors

import com.jxareas.petfinder.core.data.api.constants.ApiEndpoints
import com.jxareas.petfinder.core.data.api.constants.ApiKeys
import com.jxareas.petfinder.core.data.api.constants.ApiParameters
import com.jxareas.petfinder.core.data.api.model.token.ApiToken
import com.jxareas.petfinder.core.data.settings.PetFinderPreferences
import com.squareup.moshi.Moshi
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.time.Instant
import javax.inject.Inject

class AuthenticationInterceptor @Inject constructor(
    private val preferences: PetFinderPreferences,
) : Interceptor {

    companion object {
        private const val UNAUTHORIZED = 401
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = preferences.getToken()
        val tokenExpirationTime = Instant.ofEpochSecond(preferences.getTokenExpirationTime())
        val request = chain.request()

        val interceptedRequest: Request
        if (tokenExpirationTime.isAfter(Instant.now()))
        // Token is valid, we can proceed with the request
            interceptedRequest = chain.createAuthenticationRequest(token)
        else {
            // Token is expired, we have to refresh it
            val tokenRefreshResponse = chain.refreshToken()

            interceptedRequest = if (tokenRefreshResponse.isSuccessful) {
                val newToken = mapToken(tokenRefreshResponse)

                if (newToken.isValid()) {
                    storeNewToken(newToken)
                    chain.createAuthenticationRequest(newToken.accessToken!!)
                } else request

            } else request


        }

        return chain.deleteTokenIfUnauthorized(interceptedRequest)

    }

    private fun Interceptor.Chain.createAuthenticationRequest(token: String): Request =
        request()
            .newBuilder()
            .addHeader(ApiParameters.AUTH_HEADER, ApiParameters.TOKEN_TYPE + token)
            .build()

    private fun Interceptor.Chain.refreshToken(): Response {
        val url = request()
            .url
            .newBuilder(ApiEndpoints.AUTH_ENDPOINT)!!
            .build()

        val body = FormBody.Builder()
            .add(ApiParameters.GRANT_TYPE_KEY, ApiParameters.GRANT_TYPE_VALUE)
            .add(ApiParameters.CLIENT_ID, ApiKeys.KEY)
            .add(ApiParameters.CLIENT_SECRET, ApiKeys.SECRET)
            .build()

        val tokenRefreshRequest = request()
            .newBuilder()
            .post(body)
            .url(url)
            .build()

        return deleteTokenIfUnauthorized(tokenRefreshRequest)

    }

    private fun Interceptor.Chain.deleteTokenIfUnauthorized(request: Request): Response {
        val response = proceed(request)

        if (response.code == UNAUTHORIZED)
            preferences.deleteTokenInfo()

        return response
    }

    private fun mapToken(tokenRefreshResponse: Response): ApiToken {
        val moshi = Moshi.Builder().build()
        val tokenAdapter = moshi.adapter(ApiToken::class.java)
        val responseBody = tokenRefreshResponse.body!!
        return tokenAdapter.fromJson(responseBody.toString()) ?: ApiToken.INVALID
    }

    private fun storeNewToken(apiToken: ApiToken) =
        with(preferences) {
            putTokenType(apiToken.tokenType!!)
            putToken(apiToken.accessToken!!)
            putTokenExpirationTime(apiToken.expiresAt)
        }

}