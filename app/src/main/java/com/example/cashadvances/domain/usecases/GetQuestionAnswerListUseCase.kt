package com.example.cashadvances.domain.usecases

import com.example.cashadvances.domain.entities.QuestionAnswerItem
import com.example.cashadvances.domain.repositories.PaydayLoansRepository

class GetQuestionAnswerListUseCase(private val paydayLoansRepository: PaydayLoansRepository) {

    suspend operator fun invoke(): List<QuestionAnswerItem> {
        return paydayLoansRepository.getQuestionAnswerList()
    }

}