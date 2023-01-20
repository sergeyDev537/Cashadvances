package com.example.cashadvances.data.newtwork

import com.example.cashadvances.domain.entities.KeyItem
import com.example.cashadvances.domain.entities.QuestionAnswerItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("delta/go.php")
    suspend fun getVisibleKey(): Response<KeyItem>

    @GET("delta/help.php")
    suspend fun getQuestionAnswerList(): Response<List<QuestionAnswerItem>>

}