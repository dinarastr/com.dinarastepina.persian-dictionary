package com.dinarastepina.routes

import com.dinarastepina.models.Word
import com.dinarastepina.service.DictionaryService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getWordDetails(service: DictionaryService) {
    get("/dictionary/word") {
        val id = call.request.queryParameters["id"].orEmpty()

        service.findOne(id)?.let { word ->
            call.respond(
                message = word,
                status = HttpStatusCode.OK
            )
        } ?: call.respond(
            message = emptyList<Word>(),
            status = HttpStatusCode.BadRequest
        )
    }
}