package com.dinarastepina.routes

import com.dinarastepina.models.ApiResponse
import com.dinarastepina.service.DictionaryService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.searchWords(service: DictionaryService) {
    get("/dictionary/search") {
        val query = call.request.queryParameters["query"].orEmpty()
        val lastFetchedId = call.request.queryParameters["lastFetchedId"].orEmpty()

        call.respond(
            message = ApiResponse(
                success = true,
                words = service.searchWords(query, lastFetchedId)
            ),
            status = HttpStatusCode.OK
        )
    }
}