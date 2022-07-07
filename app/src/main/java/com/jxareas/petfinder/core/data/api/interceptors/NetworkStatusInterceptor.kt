package com.jxareas.petfinder.core.data.api.interceptors

import com.jxareas.petfinder.core.data.api.connection.ConnectionManager
import com.jxareas.petfinder.core.domain.exception.NetworkUnavailableException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkStatusInterceptor @Inject constructor(
    private val connectionManager: ConnectionManager,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        if (connectionManager.isConnected())
            chain.proceed(chain.request())
        else throw NetworkUnavailableException()

}