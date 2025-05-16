package com.example.aibirthdaywisher.data.model

data class CardTemplate(
    val id: Long,
    val title: String,
    val message: String,
    val imageUrl: String? = null
)