package com.jxareas.petfinder.core.data.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiAddress(
    @field:Json(name = "address1") val address1: String?,
    @field:Json(name = "address2") val address2: String?,
    @field:Json(name = "city") val city: String?,
    @field:Json(name = "state") val state: String?,
    @field:Json(name = "postcode") val postcode: String?,
    @field:Json(name = "country") val country: String?
)
