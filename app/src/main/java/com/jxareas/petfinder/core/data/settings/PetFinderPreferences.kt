package com.jxareas.petfinder.core.data.settings

interface PetFinderPreferences {

    fun putToken(token: String)

    fun getToken(): String

    fun putTokenExpirationTime(tokenExpirationTime: Long)

    fun getTokenExpirationTime(): Long

    fun putTokenType(tokenType: String)

    fun getTokenType(): String

    fun deleteTokenInfo()

}