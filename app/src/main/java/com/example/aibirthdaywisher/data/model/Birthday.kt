package com.example.aibirthdaywisher.data.model

import java.util.Date

data class Birthday(
    val id: Long,
    val name: String,
    val date: Date,
    val message: String
)