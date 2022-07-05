package com.jxareas.petfinder.core.data.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiContact(
    @field:Json(name = "email") val email: String?,
    @field:Json(name = "phone") val phone: String?,
    @field:Json(name = "address") val address: ApiAddress?
)
