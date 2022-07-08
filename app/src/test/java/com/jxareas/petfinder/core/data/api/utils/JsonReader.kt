package com.jxareas.petfinder.core.data.api.utils

import androidx.test.platform.app.InstrumentationRegistry
import java.io.IOException
import java.io.InputStream

object JsonReader {

    private const val RESPONSE_ASSETS = "networkresponses/"

    fun getJson(path: String): String =
        try {
            val context = InstrumentationRegistry.getInstrumentation().context
            val jsonStream: InputStream = context.assets.open("$RESPONSE_ASSETS/$path")
            String(jsonStream.readBytes())
        } catch (exception: IOException) {
            throw exception
        }

}