package com.jxareas.petfinder.core.domain.model.animal.vo

class Breed(val primary: String, val secondary: String) {
    val mixed: Boolean
        get() = primary.isNotEmpty() && secondary.isNotEmpty()

    val unknown: Boolean
        get() = primary.isEmpty() && secondary.isEmpty()
}
