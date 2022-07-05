package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.model.animal.ApiAddress
import com.jxareas.petfinder.core.domain.model.organization.Organization
import javax.inject.Inject

class ApiAdressMapper @Inject constructor() : ApiMapper<ApiAddress?, Organization.Address> {
    override fun mapToDomain(apiEntity: ApiAddress?): Organization.Address =
        Organization.Address(
            address1 = apiEntity?.address1.orEmpty(),
            address2 = apiEntity?.address2.orEmpty(),
            city = apiEntity?.city.orEmpty(),
            state = apiEntity?.state.orEmpty(),
            postcode = apiEntity?.postcode.orEmpty(),
            country = apiEntity?.country.orEmpty(),
        )
}
