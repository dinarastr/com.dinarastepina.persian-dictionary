package com.dinarastepina

import com.dinarastepina.plugins.*
import com.dinarastepina.repository.DictionaryRepository
import com.dinarastepina.service.DictionaryService
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.core.parameter.parametersOf
import org.koin.ktor.ext.inject
import org.litote.kmongo.coroutine.CoroutineClient

fun main(args: Array<String>) {
    embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}

fun Application.module() {
    configureKoin()
    configureDefaultHeader()
    configureSerialization()
    configureMonitoring()

    val uri = environment.config.property("ktor.mongoUri").getString()

    val coroutineClient: CoroutineClient by inject {
        parametersOf(uri)
    }

    val repository: DictionaryRepository by inject {
        parametersOf(coroutineClient)
    }

    val service: DictionaryService by inject {
        parametersOf(repository)
    }

    configureRouting(service)
}
