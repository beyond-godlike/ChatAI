package com.example.chatai.presentation.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatai.data.ChatApi
import com.example.chatai.data.Message
import com.example.chatai.data.Sender
import com.example.chatai.data.toDomain
import com.example.chatai.data.toDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val api: ChatApi) : ViewModel() {
    private val _state = MutableStateFlow<ChatState>(ChatState.Success(emptyList()))
    val state: StateFlow<ChatState> = _state.asStateFlow()

    fun dispatch(intent: ChatIntent) {
        when (intent) {
            is ChatIntent.SendMessage -> {
                sendMessage(intent.text)
            }
        }
    }

    private fun sendMessage(text: String) {
        val userMessage = Message(
            text = text,
            sender = Sender.USER,
            timestamp = System.currentTimeMillis()
        )

        addMessage(userMessage)

        viewModelScope.launch {

            runCatching {
                api.sendMsg(
                    userMessage.toDto()
                )
            }.onSuccess { response ->

                response.body()
                    ?.toDomain()
                    ?.let(::addMessage)

            }.onFailure { e ->

                _state.value =
                    ChatState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun addMessage(message: Message) {
        _state.update { currentState ->
            if (currentState is ChatState.Success) {
                currentState.copy(messages = currentState.messages + message)
            } else {
                currentState
            }
        }
    }

}