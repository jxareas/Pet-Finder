package com.jxareas.petfinder.core.domain.model.animal

import com.jxareas.petfinder.core.domain.model.animal.vo.AdoptionStatus
import com.jxareas.petfinder.core.domain.model.animal.vo.AnimalDetails
import com.jxareas.petfinder.core.domain.model.animal.vo.Media
import org.threeten.bp.LocalDateTime

data class AnimalWithDetails(
    val id: Long,
    val name: String,
    val type: String,
    val details: AnimalDetails,
    val media: Media,
    val tags: List<String>,
    val adoptionStatus: AdoptionStatus,
    val publishedAt: LocalDateTime,
)