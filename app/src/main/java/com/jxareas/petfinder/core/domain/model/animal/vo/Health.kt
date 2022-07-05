package com.jxareas.petfinder.core.domain.model.animal.vo

data class Health(
    val isSpayedOrNeutered: Boolean,
    val isDeclawed: Boolean,
    val hasSpecialNeeds: Boolean,
    val shotsAreCurrent: Boolean,
)
