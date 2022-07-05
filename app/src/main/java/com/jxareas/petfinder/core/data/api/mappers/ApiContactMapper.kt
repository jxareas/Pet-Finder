package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.model.animal.ApiContact
import com.jxareas.petfinder.core.domain.model.organization.Organization
import javax.inject.Inject

class ApiContactMapper @Inject constructor(
    private val adressMapper: ApiAdressMapper,
) : ApiMapper<ApiContact?, Organization.Contact> {
    override fun mapToDomain(apiEntity: ApiContact?): Organization.Contact =
        Organization.Contact(
            email = apiEntity?.email.orEmpty(),
            phone = apiEntity?.phone.orEmpty(),
            address = adressMapper.mapToDomain(apiEntity?.address)
        )

}
