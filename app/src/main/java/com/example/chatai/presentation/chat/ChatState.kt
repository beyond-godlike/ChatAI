package com.example.chatai.presentation.chat

import com.example.chatai.presentation.home.HomeScreenState

sealed class ChatState {
    object Empty : ChatState()
    data class Error(val e: String) : ChatState()
    //data class Success(val answer: String) : ChatState()
    data class Success(val messages: List<Message>) : ChatState()
}