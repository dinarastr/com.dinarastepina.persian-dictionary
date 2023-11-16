package com.dinarastepina.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId

@Serializable
data class Word(
    @BsonId
    val _id: String? = null,
    val EnglishWord: String,
    val Meanings: List<String>
)
