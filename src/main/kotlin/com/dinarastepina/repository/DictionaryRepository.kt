package com.dinarastepina.repository

import com.dinarastepina.models.Word
import com.dinarastepina.util.Constants
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.CoroutineClient

class DictionaryRepository(private val coroutineClient: CoroutineClient) {


    suspend fun findAllConferences(
        lastFetchedId: String
    ): List<Word> {
        val filter: Bson = Document("_id", Document("\$gt", ObjectId(lastFetchedId)))

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