package com.example.chatai.presentation.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatai.data.ChatApi
import com.example.chatai.data.Msg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
            is ChatIntent.Predict -> {
                addMessage(intent.message)
                // do async
                viewModelScope.launch(Dispatchers.IO) {
                    runCatching {
                        api.sendMsg(Msg(intent.message.text)).body()?.reply

                    }.fold(
                        onSuccess = { response ->
                            addMessage(Message(response.toString() ?: "no response", "sender"))
                        },
                        onFailure = { e ->
                            _state.value = ChatState.Error("error: ${e.message}")
                        }
                    )
                }
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