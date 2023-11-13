package com.dinarastepina.service

import com.dinarastepina.models.Word
import com.dinarastepina.repository.DictionaryRepository

class DictionaryService (private val repository: DictionaryRepository) {

    suspend fun findAll(): List<Word> = repository.findAllConferences()

    suspend fun findOne(id: String): Word? = repository.findOneConference(id)
}