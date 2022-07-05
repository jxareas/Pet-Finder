package com.jxareas.petfinder.core.utils

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

object DateTimeUtils {
    private const val DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ"

    fun parse(dateTime: String): LocalDateTime =
        try {
            LocalDateTime.parse(dateTime)
        } catch (exception: Exception) {
            val dateFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN)
            LocalDateTime.parse(dateTime, dateFormatter)
        }
}