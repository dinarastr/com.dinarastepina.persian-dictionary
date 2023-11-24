package com.dinarastepina.repository

import com.dinarastepina.models.Word
import com.dinarastepina.util.Constants
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import org.litote.kmongo.EMPTY_BSON
import org.litote.kmongo.coroutine.CoroutineClient

class DictionaryRepository(private val coroutineClient: CoroutineClient) {


    suspend fun findAllConferences(
        lastFetchedId: String,
        pageSize: Int
    ): List<Word> {
        val filter: Bson = if (lastFetchedId.isNotEmpty()) Document("_id", Document("\$gt", ObjectId(lastFetchedId))) else EMPTY_BSON

        return collection()
            .find(
                filter
            )
            .limit(pageSize)
            .toList()
    }

    suspend fun searchWords(
        query: String,
        lastFetchedId: String,
        pageSize: Int
    ): List<Word> {
        val filter: Bson = if (lastFetchedId.isNotEmpty()) Document("EnglishWord", Document("\$regex", query)).append(
            "_id", Document("\$gt", ObjectId(lastFetchedId))
        ) else Document("EnglishWord", Document("\$regex", query))

        return collection()
            .find(
                filter
            )
            .limit(pageSize)
            .toList()
    }

    suspend fun findOneConference(id: String): Word? {
        val filter = Document("_id", Document("\$eq", ObjectId(id)))
        return collection().findOne(filter)
    }


    private fun collection() =
        coroutineClient
            .getDatabase(Constants.DATABASE_NAME)
            .getCollection<Word>(Constants.COLLECTION_NAME_V2)

}