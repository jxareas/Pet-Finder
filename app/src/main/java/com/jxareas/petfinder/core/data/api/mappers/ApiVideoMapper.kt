package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.model.animal.ApiVideoLink
import com.jxareas.petfinder.core.domain.model.animal.vo.Media
import javax.inject.Inject

class ApiVideoMapper @Inject constructor() : ApiMapper<ApiVideoLink?, Media.Video> {

    override fun mapToDomain(apiEntity: ApiVideoLink?): Media.Video =
        Media.Video(video = apiEntity?.embed.orEmpty())

}
