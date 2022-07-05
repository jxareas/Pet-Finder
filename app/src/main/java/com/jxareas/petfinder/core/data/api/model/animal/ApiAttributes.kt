package com.jxareas.petfinder.core.data.api.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiAttributes(
    @field:Json(name = "spayed_neutered") val spayedNeutered: Boolean?,
    @field:Json(name = "house_trained") val houseTrained: Boolean?,
    @field:Json(name = "declawed") val declawed: Boolean?,
    @field:Json(name = "special_needs") val specialNeeds: Boolean?,
    @field:Json(name = "shots_current") val shotsCurrent: Boolean?
)
