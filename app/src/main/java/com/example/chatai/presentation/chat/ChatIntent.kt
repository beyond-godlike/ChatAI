package com.example.chatai.presentation.chat

import com.example.chatai.data.Message

sealed class ChatIntent {
    data class SendMessage(
        val text: String
    ) : ChatIntent()
}