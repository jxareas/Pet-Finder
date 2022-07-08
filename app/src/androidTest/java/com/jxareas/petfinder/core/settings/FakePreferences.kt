package com.jxareas.petfinder.core.settings

import com.jxareas.petfinder.core.data.settings.PetFinderPreferences
import com.jxareas.petfinder.core.data.settings.PreferenceConstants

class FakePreferences : PetFinderPreferences {

    private val preferences = mutableMapOf<String, Any>()

    override fun putToken(token: String) {
        preferences[PreferenceConstants.TOKEN] = token
    }

    override fun getToken(): String =
        preferences[PreferenceConstants.TOKEN] as String


    override fun putTokenExpirationTime(tokenExpirationTime: Long) {
        preferences[PreferenceConstants.TOKEN_EXPIRATION_TIME] = tokenExpirationTime
    }

    override fun getTokenExpirationTime(): Long =
        preferences[PreferenceConstants.TOKEN_EXPIRATION_TIME] as Long

    override fun putTokenType(tokenType: String) {
        preferences[PreferenceConstants.TOKEN_TYPE] = tokenType
    }

    override fun getTokenType(): String =
        preferences[PreferenceConstants.TOKEN_TYPE] as String

    override fun deleteTokenInfo() =
        preferences.clear()


}