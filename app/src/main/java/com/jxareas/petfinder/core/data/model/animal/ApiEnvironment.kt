package com.jxareas.petfinder.core.data.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiEnvironment(
    @field:Json(name = "children") val children: Boolean?,
    @field:Json(name = "dogs") val dogs: Boolean?,
    @field:Json(name = "cats") val cats: Boolean?
)
