package com.jxareas.petfinder.core.data.api.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiColors(
    @field:Json(name = "primary") val primary: String?,
    @field:Json(name = "secondary") val secondary: String?,
    @field:Json(name = "tertiary") val tertiary: String?
)
