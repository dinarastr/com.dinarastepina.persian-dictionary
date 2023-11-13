package com.dinarastepina.models

import kotlinx.serialization.Serializable

@Serializable
data class Word(
    val id: Int,
    val english: String,
    val meanings: List<String>
)
