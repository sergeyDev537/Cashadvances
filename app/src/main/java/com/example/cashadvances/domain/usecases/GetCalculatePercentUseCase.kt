package com.example.cashadvances.domain.usecases

import com.example.cashadvances.domain.entities.CalculatePercent
import com.example.cashadvances.domain.repositories.CalculateRepository

class GetCalculatePercentUseCase(private val calculateRepository: CalculateRepository) {

    operator fun invoke(
        loanAmount: String,
        loanTerm: String,
        interestRate: String
    ): CalculatePercent{
        return calculateRepository.getCalculatePercent(loanAmount, loanTerm, interestRate)
    }

}