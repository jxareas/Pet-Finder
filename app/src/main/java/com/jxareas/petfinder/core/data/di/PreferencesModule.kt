package com.jxareas.petfinder.core.data.di

import com.jxareas.petfinder.core.data.settings.PetFinderPreferences
import com.jxareas.petfinder.core.data.settings.PetFinderPreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PreferencesModule {

    @Binds
    fun bindPetFinderPreferences(preferences: PetFinderPreferencesImpl):
            PetFinderPreferences

}