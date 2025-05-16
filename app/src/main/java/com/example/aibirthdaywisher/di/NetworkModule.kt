package com.example.aibirthdaywisher.di

import com.example.aibirthdaywisher.network.AIService
import com.example.aibirthdaywisher.network.RetrofitClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return RetrofitClient.getRetrofitInstance()
    }

    @Provides
    @Singleton
    fun provideAIService(retrofit: Retrofit): AIService {
        return retrofit.create(AIService::class.java)
    }
}