

package com.jxareas.petfinder.core.data.model.animal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiAnimal(
    @field:Json(name = "id") val id: Long?,
    @field:Json(name = "organization_id") val organizationId: String?,
    @field:Json(name = "url") val url: String?,
    @field:Json(name = "type") val type: String?,
    @field:Json(name = "species") val species:String?,
    @field:Json(name = "breeds") val breeds: ApiBreeds?,
    @field:Json(name = "colors") val colors: ApiColors?,
    @field:Json(name = "age") val age: String?,
    @field:Json(name = "gender") val gender: String?,
    @field:Json(name = "size") val size: String?,
    @field:Json(name = "coat") val coat: String?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "photos") val photos: List<ApiPhotoSizes>?,
    @field:Json(name = "videos") val videos: List<ApiVideoLink>?,
    @field:Json(name = "status") val status: String?,
    @field:Json(name = "attributes") val attributes: ApiAttributes?,
    @field:Json(name = "environment") val environment: ApiEnvironment?,
    @field:Json(name = "tags") val tags: List<String?>?,
    @field:Json(name = "contact") val contact: ApiContact?,
    @field:Json(name = "published_at") val publishedAt: String?,
    @field:Json(name = "distance") val distance: Float?
)
