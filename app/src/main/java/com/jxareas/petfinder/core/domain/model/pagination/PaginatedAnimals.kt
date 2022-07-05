package com.jxareas.petfinder.core.domain.model.pagination

import com.jxareas.petfinder.core.domain.model.animal.AnimalWithDetails

data class PaginatedAnimals(
    val animals: List<AnimalWithDetails>,
    val pagination: Pagination,
)