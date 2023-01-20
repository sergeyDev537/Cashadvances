package com.example.cashadvances.domain.entities

import com.google.gson.annotations.SerializedName

data class QuestionAnswerItem(
    @SerializedName("theme")
    val question: String,
    @SerializedName("description")
    val answer: String
)