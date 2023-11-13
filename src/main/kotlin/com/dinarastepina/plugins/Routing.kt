package com.dinarastepina.plugins

import com.dinarastepina.routes.getAllWords
import com.dinarastepina.routes.root
import com.dinarastepina.service.DictionaryService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    service: DictionaryService
) {
    routing {
        getAllWords(service)
    }
}
