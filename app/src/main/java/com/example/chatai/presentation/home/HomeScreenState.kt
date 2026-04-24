package com.example.chatai.presentation.home

sealed class HomeScreenState {
    object Idle : HomeScreenState()
    data class Success(val answer: String) : HomeScreenState()
    data class Error(val errorMessage: String) : HomeScreenState()
}