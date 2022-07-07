package com.jxareas.petfinder.core.data.settings

interface Preferences {

    fun putToken(token: String)

    fun getToken(): String

    fun putTokenExpirationTime(tokenExpirationTime: Long)

    fun getTokenExpirationTime(): Long

    fun putTokenType(token: String)

    fun getTokenType(): String

    fun deleteTokenInfo()

}