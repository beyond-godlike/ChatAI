package com.example.chatai.domain.di

import com.example.chatai.data.ChatApi
import com.example.chatai.data.local.MessageDao
import com.example.chatai.data.repository.ChatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideChatRepository(
        api: ChatApi,
        dao: MessageDao
    ): ChatRepository {
        return ChatRepository(api, dao)
    }
}