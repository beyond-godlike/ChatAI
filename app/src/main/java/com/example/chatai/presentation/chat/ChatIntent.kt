package com.example.chatai.presentation.chat

sealed class ChatIntent {
    data class Predict(val message: Message) : ChatIntent()
}