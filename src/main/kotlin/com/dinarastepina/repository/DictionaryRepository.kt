package com.dinarastepina.repository

import com.dinarastepina.models.Word
import com.dinarastepina.util.Constants
import com.mongodb.client.model.BsonField
import com.mongodb.client.model.Filters
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.CoroutineClient

class DictionaryRepository(private val coroutineClient: CoroutineClient) {


    suspend fun findAllConferences(
        lastFetchedWord: String
    ): List<Word> {
        val filter = Filters.gt(
            "EnglishWord", lastFetchedWord
        )
        return collection()
            .find(
                filter
            )
            .limit(20)
            .toList()
    }

    suspend fun findOneConference(id: String): Word? = collection().findOneById(id)


    private fun collection() =
        coroutineClient
            .getDatabase(Constants.DATABASE_NAME)
            .getCollection<Word>(Constants.COLLECTION_NAME_V2)

}