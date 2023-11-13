package com.dinarastepina.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.root() {
    get("/") {
        call.respond(
            message = "Welcome to Persian CS Dictionary!",
            status = HttpStatusCode.OK
        )
    }
}