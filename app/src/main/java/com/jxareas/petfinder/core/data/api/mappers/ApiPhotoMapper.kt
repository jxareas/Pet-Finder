package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.model.animal.ApiPhotoSizes
import com.jxareas.petfinder.core.domain.model.animal.vo.Media
import javax.inject.Inject

class ApiPhotoMapper @Inject constructor() : ApiMapper<ApiPhotoSizes?, Media.Photo> {

    override fun mapToDomain(apiEntity: ApiPhotoSizes?): Media.Photo =
        Media.Photo(
            medium = apiEntity?.medium.orEmpty(),
            full = apiEntity?.full.orEmpty()
        )

}
