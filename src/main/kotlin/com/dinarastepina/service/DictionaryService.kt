package com.dinarastepina.service

import com.dinarastepina.models.Word
import com.dinarastepina.repository.DictionaryRepository

class DictionaryService (private val repository: DictionaryRepository) {

    suspend fun findAll(lastFetchedId: String, pageSize: Int): List<Word> =
        repository.findAllConferences(lastFetchedId, pageSize)

    suspend fun searchWords(query: String, lastFetchedId: String, pageSize: Int):
            List<Word> = repository.searchWords(query, lastFetchedId, pageSize)

    suspend fun findOne(id: String): Word? = repository.findOneConference(id)
}