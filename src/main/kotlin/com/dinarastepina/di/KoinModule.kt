package com.dinarastepina.di

import com.dinarastepina.repository.DictionaryRepository
import com.dinarastepina.service.DictionaryService
import org.koin.dsl.module
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val appModule = module {
    single { (uri: String) -> KMongo.createClient(uri).coroutine }
    single { (client: CoroutineClient) -> DictionaryRepository(client) }
    single { (repository: DictionaryRepository) -> DictionaryService(repository) }
}