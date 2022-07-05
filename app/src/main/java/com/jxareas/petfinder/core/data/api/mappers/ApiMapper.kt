package com.jxareas.petfinder.core.data.api.mappers

interface ApiMapper<E, D> {
    fun mapToDomain(apiEntity: E): D
}
