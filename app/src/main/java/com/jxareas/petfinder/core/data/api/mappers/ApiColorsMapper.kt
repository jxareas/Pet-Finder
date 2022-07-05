package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.model.animal.ApiColors
import com.jxareas.petfinder.core.domain.model.animal.vo.Colors
import javax.inject.Inject

class ApiColorsMapper @Inject constructor() : ApiMapper<ApiColors?, Colors> {

    override fun mapToDomain(apiEntity: ApiColors?): Colors =
        Colors(
            primary = apiEntity?.primary.orEmpty(),
            secondary = apiEntity?.secondary.orEmpty(),
            tertiary = apiEntity?.primary.orEmpty(),
        )

}
