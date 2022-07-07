package com.jxareas.petfinder.core.domain.exception

import java.io.IOException

class NetworkUnavailableException(message: String = "No Network Unavailable") :
    IOException(message)