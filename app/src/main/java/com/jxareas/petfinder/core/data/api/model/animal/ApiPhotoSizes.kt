package com.jxareas.petfinder.core.data.api.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiPhotoSizes(
    @field:Json(name = "small") val small: String?,
    @field:Json(name = "medium") val medium: String?,
    @field:Json(name = "large") val large: String?,
    @field:Json(name = "full") val full: String?
)
