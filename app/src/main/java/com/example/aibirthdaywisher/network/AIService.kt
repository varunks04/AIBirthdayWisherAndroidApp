package com.example.aibirthdaywisher.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AIService {
    @POST("generateBirthdayMessage")
    fun generateBirthdayMessage(@Body request: BirthdayMessageRequest): Call<BirthdayMessageResponse>
}

data class BirthdayMessageRequest(val name: String, val age: Int)

data class BirthdayMessageResponse(val message: String)