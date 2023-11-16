package com.dinarastepina.routes

import com.dinarastepina.models.ApiResponse
import com.dinarastepina.service.DictionaryService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllWords(service: DictionaryService) {
    get("/dictionary") {
        val lastFetchedId = call.request.queryParameters["lastFetchedId"].orEmpty()

        call.respond(
                message = ApiResponse(
                    success = true,
                    words = service.findAll(lastFetchedId)
                )
            )
    }
}