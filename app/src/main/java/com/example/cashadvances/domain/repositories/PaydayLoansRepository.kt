package com.example.cashadvances.domain.repositories

import com.example.cashadvances.domain.entities.QuestionAnswerItem

interface PaydayLoansRepository {

    fun getUrlPaydayLoans(): String

    fun getInstallmentLoans(): String

    suspend fun getQuestionAnswerList(): List<QuestionAnswerItem>

    fun getUrlLegality(): String

    fun getPrivacyPolicy(): String

}