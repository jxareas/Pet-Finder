package com.jxareas.petfinder.core.data.settings

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PreferencesImpl @Inject constructor(
    @ApplicationContext context: Context,
) : Preferences {

    companion object {
        const val PREFERENCES_NAME = "PET_SAVE_PREFERENCES"
    }

    private val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    private inline fun edit(block: SharedPreferences.Editor.() -> Unit) =
        with(preferences.edit()) {
            block()
            commit()
            return@with
        }

    override fun putToken(token: String) =
        edit {
            putString(PreferenceConstants.TOKEN, token)
        }


    override fun getToken() =
        preferences.getString(PreferenceConstants.TOKEN, "").orEmpty()

    override fun putTokenExpirationTime(tokenExpirationTime: Long) =
        edit {
            putLong(PreferenceConstants.TOKEN_EXPIRATION_TIME, tokenExpirationTime)
        }

    override fun getTokenExpirationTime() =
        preferences.getLong(PreferenceConstants.TOKEN_EXPIRATION_TIME, -1)

    override fun putTokenType(token: String) =
        edit {
            putString(PreferenceConstants.TOKEN_TYPE, token)
        }

    override fun getTokenType() =
        preferences.getString(PreferenceConstants.TOKEN_TYPE, "").orEmpty()

    override fun deleteTokenInfo() =
        edit {
            remove(PreferenceConstants.TOKEN)
            remove(PreferenceConstants.TOKEN_TYPE)
            remove(PreferenceConstants.TOKEN_EXPIRATION_TIME)
        }


}