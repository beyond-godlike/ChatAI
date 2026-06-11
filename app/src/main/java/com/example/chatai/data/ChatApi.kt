package com.example.chatai.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatApi {
    @POST("chat")
    suspend fun sendMsg(@Body msg: MessageDto): Response<MessageDto>
}