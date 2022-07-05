package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.model.animal.ApiEnvironment
import com.jxareas.petfinder.core.domain.model.animal.vo.HabitatAdaptation
import javax.inject.Inject

class ApiHabitatAdaptationMapper @Inject constructor() :
    ApiMapper<ApiEnvironment?, HabitatAdaptation> {

    override fun mapToDomain(apiEntity: ApiEnvironment?): HabitatAdaptation =
        HabitatAdaptation(
            goodWithChildren = apiEntity?.children ?: true,
            goodWithDogs = apiEntity?.dogs ?: true,
            goodWithCats = apiEntity?.cats ?: true
        )
}
