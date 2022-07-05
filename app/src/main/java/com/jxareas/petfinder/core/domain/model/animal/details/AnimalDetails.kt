package com.jxareas.petfinder.core.domain.model.animal.details

import com.jxareas.petfinder.core.domain.model.organization.Organization

data class AnimalDetails(
    val description: String,
    val age: Age,
    val species: String,
    val breed: Breed,
    val colors: Colors,
    val gender: Gender,
    val size: Size,
    val coat: Coat,
    val health: Health,
    val habitatAdaptation: HabitatAdaptation,
    val organization: Organization,
)
