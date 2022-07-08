package com.jxareas.petfinder.core.api.utils

import com.jxareas.petfinder.core.data.api.constants.ApiEndpoints
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

class FakeServer {

    private val mockWebServer = MockWebServer()

    private val endpointSeparator = "/"
    private val animalsEndpoint = endpointSeparator + ApiEndpoints.ANIMALS_ENDPOINT

    private val animalsResponse =
        MockResponse().setResponseCode(OK_CODE).setBody(getJson("animals.json"))
    private val notFoundResponse = MockResponse().setResponseCode(NOT_FOUND_CODE)

    val baseEndpoint
        get() = mockWebServer.url(endpointSeparator)

    companion object {
        private const val NOT_FOUND_CODE = 404
        private const val OK_CODE = 200
    }

    fun start() {
        mockWebServer.start(8080)
    }

    fun setHappyPathDispatcher() {
        mockWebServer.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                val path = request.path ?: return notFoundResponse

                return with(path) {
                    if (startsWith(animalsEndpoint))
                        animalsResponse
                    else notFoundResponse
                }
            }

        }
    }

    fun shutDown() {
        mockWebServer.shutdown()
    }


    private fun getJson(path: String): String =
        JsonReader.getJson(path)

}