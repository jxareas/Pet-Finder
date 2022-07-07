package com.jxareas.petfinder.core.data.api.model.token

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.threeten.bp.Instant

@JsonClass(generateAdapter = true)
data class ApiToken(
    @field:Json(name = "token_type") val tokenType: String?,
    @field:Json(name = "expires_in") val expiresInSeconds: Int?,
    @field:Json(name = "access_token") val accessToken: String?,
) {
    companion object {
        val INVALID = ApiToken("", -1, "")
    }

    @Transient
    private val requestedAt: Instant = Instant.now()

    val expiresAt: Long
        get() =
            if (expiresInSeconds == null)
                0L
            else requestedAt.plusSeconds(expiresInSeconds.toLong()).epochSecond

    fun isValid(): Boolean =
        tokenType != null && tokenType.isNotEmpty() &&
                expiresInSeconds != null && expiresInSeconds >= 0 &&
                accessToken != null && accessToken.isNotEmpty()


}
