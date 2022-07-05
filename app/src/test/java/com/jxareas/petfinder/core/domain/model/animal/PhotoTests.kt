package com.jxareas.petfinder.core.domain.model.animal

import com.jxareas.petfinder.core.domain.model.animal.vo.Media
import org.junit.Assert.assertEquals
import org.junit.Test

class PhotoTests {
    private val mediumPhoto = "mediumPhoto"
    private val fullPhoto = "fullPhoto"
    private val invalidPhoto = ""/** Photo.isValidPhoto() tests for an empty string
     *  @see com.jxareas.petfinder.core.domain.model.animal.vo.Media.Photo.isValidPhoto**/


    @Test
    fun getSmallestAvailablePhoto_hasMediumPhoto() {
        // Given
        val photo = Media.Photo(medium = mediumPhoto, full = fullPhoto)
        val expectedValue = mediumPhoto

        // When
        val smallestPhoto = photo.getSmallestAvailablePhoto()

        // Then
        assertEquals(expectedValue, smallestPhoto)
    }

    @Test
    fun getSmallestAvailablePhoto_hasNoMediumPhoto() {
        // Given
        val photo = Media.Photo(invalidPhoto, fullPhoto)
        val expectedValue = fullPhoto

        // When
        val smallestPhoto = photo.getSmallestAvailablePhoto()

        // Then
        assertEquals(expectedValue, smallestPhoto)
    }

    @Test
    fun getSmallestAvailablePhoto_hasNoPhoto() {
        // Given
        val photo = Media.Photo(invalidPhoto, invalidPhoto)
        val expectedValue = Media.Photo.EMPTY_PHOTO

        // When
        val smallestPhoto = photo.getSmallestAvailablePhoto()

        // Then
        assertEquals(expectedValue, smallestPhoto)
    }

}