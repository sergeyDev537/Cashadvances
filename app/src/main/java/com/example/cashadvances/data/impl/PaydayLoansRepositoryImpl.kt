package com.example.cashadvances.data.impl

import com.example.cashadvances.Config
import com.example.cashadvances.data.newtwork.Common
import com.example.cashadvances.domain.entities.QuestionAnswerItem
import com.example.cashadvances.domain.repositories.PaydayLoansRepository

object PaydayLoansRepositoryImpl: PaydayLoansRepository {

    private val apiInterface = Common.apiInterface

    override fun getUrlPaydayLoans(): String {
       return Config.URL_PAYDAY_LOANS
    }

    override fun getInstallmentLoans(): String {
        return Config.URL_INSTALLMENT_LOANS
    }

    override suspend fun getQuestionAnswerList(): List<QuestionAnswerItem> {
        return apiInterface.getQuestionAnswerList().body() ?: arrayListOf()
    }

    override fun getUrlLegality(): String {
        return Config.URL_LEGALITY_US
    }

    override fun getPrivacyPolicy(): String {
        return Config.URL_PRIVACY_POLICY
    }
}