package com.jxareas.petfinder.core.data.api.mappers

import com.jxareas.petfinder.core.data.api.exception.MappingException
import com.jxareas.petfinder.core.data.api.model.animal.ApiAnimal
import com.jxareas.petfinder.core.domain.model.animal.AnimalWithDetails
import com.jxareas.petfinder.core.domain.model.animal.vo.AdoptionStatus
import com.jxareas.petfinder.core.domain.model.animal.vo.Age
import com.jxareas.petfinder.core.domain.model.animal.vo.AnimalDetails
import com.jxareas.petfinder.core.domain.model.animal.vo.Coat
import com.jxareas.petfinder.core.domain.model.animal.vo.Gender
import com.jxareas.petfinder.core.domain.model.animal.vo.Media
import com.jxareas.petfinder.core.domain.model.animal.vo.Size
import com.jxareas.petfinder.core.domain.model.organization.Organization
import com.jxareas.petfinder.core.utils.DateTimeUtils
import java.util.*
import javax.inject.Inject

class ApiAnimalMapper @Inject constructor(
    private val apiBreedsMapper: ApiBreedsMapper,
    private val apiColorsMapper: ApiColorsMapper,
    private val apiHealthMapper: ApiHealthMapper,
    private val habitatAdaptationMapper: ApiHabitatAdaptationMapper,
    private val apiPhotoMapper: ApiPhotoMapper,
    private val apiVideoMapper: ApiVideoMapper,
    private val apiContactMapper: ApiContactMapper,
) : ApiMapper<ApiAnimal, AnimalWithDetails> {

    override fun mapToDomain(apiEntity: ApiAnimal): AnimalWithDetails =
        AnimalWithDetails(
            id = apiEntity.id ?: throw MappingException("Animal ID cannot be null"),
            name = apiEntity.name.orEmpty(),
            type = apiEntity.type.orEmpty(),
            details = parseDetails(apiEntity),
            tags = apiEntity.tags.orEmpty().map { it.orEmpty() },
            media = parseMedia(apiEntity),
            adoptionStatus = parseAdoptionStatus(apiEntity.status),
            publishedAt = DateTimeUtils.parse(apiEntity.publishedAt.orEmpty())
        )

    private fun parseAdoptionStatus(status: String?): AdoptionStatus =
        if (status.isNullOrEmpty())
            AdoptionStatus.UNKNOWN
        else AdoptionStatus.valueOf(status.uppercase(Locale.ROOT))


    private fun parseMedia(apiEntity: ApiAnimal): Media {
        val photos = apiEntity.photos?.map { photo ->
            apiPhotoMapper.mapToDomain(photo)
        }.orEmpty()
        val videos = apiEntity.videos?.map { video ->
            apiVideoMapper.mapToDomain(video)
        }.orEmpty()
        return Media(photos, videos)
    }

    private fun parseDetails(apiAnimal: ApiAnimal): AnimalDetails =
        AnimalDetails(
            description = apiAnimal.description.orEmpty(),
            age = parseAnimalAge(apiAnimal.age),
            species = apiAnimal.species.orEmpty(),
            breed = apiBreedsMapper.mapToDomain(apiAnimal.breeds),
            colors = apiColorsMapper.mapToDomain(apiAnimal.colors),
            gender = parseGender(apiAnimal.gender),
            size = parseSize(apiAnimal.size),
            coat = parseCoat(apiAnimal.coat),
            health = apiHealthMapper.mapToDomain(apiAnimal.attributes),
            habitatAdaptation = habitatAdaptationMapper.mapToDomain(apiAnimal.environment),
            organization = mapOrganization(apiAnimal),
        )

    private fun parseAnimalAge(age: String?): Age =
        if (age.isNullOrEmpty())
            Age.UNKNOWN
        else Age.valueOf(age.uppercase(Locale.getDefault()))

    private fun parseGender(gender: String?): Gender =
        if (gender.isNullOrEmpty())
            Gender.UNKNOWN
        else Gender.valueOf(gender.uppercase(Locale.ROOT))

    private fun parseSize(size: String?): Size =
        if (size.isNullOrEmpty())
            Size.UNKNOWN
        else Size.valueOf(size.replace(' ', '_').uppercase(Locale.ROOT))

    private fun parseCoat(coat: String?): Coat =
        if (coat.isNullOrEmpty())
            Coat.UNKNOWN
        else Coat.valueOf(coat.uppercase(Locale.ROOT))

    private fun mapOrganization(apiAnimal: ApiAnimal): Organization =
        Organization(
            id = apiAnimal.organizationId ?: throw MappingException("Animal ID must not be null"),
            contact = apiContactMapper.mapToDomain(apiAnimal.contact),
            distance = apiAnimal.distance ?: -1f,
        )


}