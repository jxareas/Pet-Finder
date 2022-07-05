package com.jxareas.petfinder.core.data.api.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiVideoLink(
    @field:Json(name = "embed") val embed: String?
)
