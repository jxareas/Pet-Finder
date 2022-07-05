

package com.jxareas.petfinder.core.data.model.pagination

import com.jxareas.petfinder.core.data.model.animal.ApiAnimal
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiPaginatedAnimals(
    @field:Json(name = "animals") val animals: List<ApiAnimal>?,
    @field:Json(name = "pagination") val pagination: ApiPagination?
)

