package com.example.chatai.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ChatApi {
    //@GET("classify")
    //suspend fun classify(@Query("text") message: String) : Response<PingResponse>

    @POST("chat")
    suspend fun sendMsg(@Body msg: Msg): Response<Reply>

    @POST("chat")
    suspend fun sendMessage(@Body msg: Msg): Response<String>
}