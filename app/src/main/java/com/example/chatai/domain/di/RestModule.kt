package com.example.chatai.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.chatai.data.ChatApi
import com.example.chatai.data.RetrofitFactory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestModule {
    @Provides
    @Singleton
    fun provideChatRetrofit(): Retrofit {
        return RetrofitFactory.retrofit("http://31.56.146.253:8001/")
    }

    @Provides
    @Singleton
    fun provideChatApi(retrofit: Retrofit): ChatApi {
        return retrofit.create(ChatApi::class.java)
    }
}