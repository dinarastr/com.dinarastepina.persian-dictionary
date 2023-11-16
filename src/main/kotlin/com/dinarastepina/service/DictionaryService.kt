package com.dinarastepina.service

import com.dinarastepina.models.Word
import com.dinarastepina.repository.DictionaryRepository

class DictionaryService (private val repository: DictionaryRepository) {

    suspend fun findAll(lastFetchedId: String
    ): List<Word> = repository.findAllConferences(lastFetchedId)

    suspend fun findOne(id: String): Word? = repository.findOneConference(id)
}