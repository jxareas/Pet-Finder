package com.jxareas.petfinder.core.data.service

import com.jxareas.petfinder.core.data.api.constants.ApiEndpoints
import com.jxareas.petfinder.core.data.api.constants.ApiParameters
import com.jxareas.petfinder.core.data.api.model.pagination.ApiPaginatedAnimals
import retrofit2.http.GET
import retrofit2.http.Query

interface PetFinderService {

    @GET(ApiEndpoints.ANIMALS_ENDPOINT)
    suspend fun getNearbyAnimals(
        @Query(ApiParameters.PAGE) pageToLoad: Int,
        @Query(ApiParameters.LIMIT) pageSize: Int,
        @Query(ApiParameters.LOCATION) postcode: String,
        @Query(ApiParameters.DISTANCE) maxDistance: Int,
    ): ApiPaginatedAnimals

}