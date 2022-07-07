package com.jxareas.petfinder.core.data.di

import com.jxareas.petfinder.core.data.api.constants.ApiEndpoints
import com.jxareas.petfinder.core.data.api.interceptors.AuthenticationInterceptor
import com.jxareas.petfinder.core.data.api.interceptors.NetworkStatusInterceptor
import com.jxareas.petfinder.core.data.service.PetFinderService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        networkStatusInterceptor: NetworkStatusInterceptor,
        authenticationInterceptor: AuthenticationInterceptor,
    ) = OkHttpClient.Builder()
        .addInterceptor(networkStatusInterceptor)
        .addInterceptor(authenticationInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiEndpoints.BASE_ENDPOINT)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providePetFinderService(retrofit: Retrofit): PetFinderService =
        retrofit.create()

}