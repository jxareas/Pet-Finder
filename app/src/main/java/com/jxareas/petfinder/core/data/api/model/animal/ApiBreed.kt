package com.jxareas.petfinder.core.data.api.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiBreed(
    @field:Json(name = "primary") val primary: String?,
    @field:Json(name = "secondary") val secondary: String?,
    @field:Json(name = "mixed") val mixed: Boolean?,
    @field:Json(name = "unknown") val unknown: Boolean?
)
