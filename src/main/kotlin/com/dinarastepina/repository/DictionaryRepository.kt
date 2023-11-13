package com.dinarastepina.repository

import com.dinarastepina.models.Word
import com.dinarastepina.util.Constants
import org.litote.kmongo.coroutine.CoroutineClient

class DictionaryRepository(private val coroutineClient: CoroutineClient) {


    suspend fun findAllConferences(): List<Word> =
        collection()
            .find()
            .toList()

    suspend fun findOneConference(id: String): Word? = collection().findOneById(id)


    private fun collection() =
        coroutineClient
            .getDatabase(Constants.DATABASE_NAME)
            .getCollection<Word>(Constants.COLLECTION_NAME_V2)

}