package com.jxareas.petfinder.core.domain.model.pet.details

data class Health(
    val isSpayedOrNeutered: Boolean,
    val isDeclawed: Boolean,
    val hasSpecialNeeds: Boolean,
    val shotsAreCurrent: Boolean,
)
