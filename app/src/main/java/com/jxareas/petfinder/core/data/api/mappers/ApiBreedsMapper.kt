package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.model.animal.ApiBreed
import com.jxareas.petfinder.core.domain.model.animal.vo.Breed
import javax.inject.Inject

class ApiBreedsMapper @Inject constructor() : ApiMapper<ApiBreed?, Breed> {
    override fun mapToDomain(apiEntity: ApiBreed?): Breed =
        Breed(
            primary = apiEntity?.primary.orEmpty(),
            secondary = apiEntity?.secondary.orEmpty(),
        )
}
