package com.example.cashadvances.domain.usecases

import com.example.cashadvances.domain.repositories.PaydayLoansRepository

class GetInstallmentLoansUseCase(private val paydayLoansRepository: PaydayLoansRepository) {

    operator fun invoke(): String {
        return paydayLoansRepository.getInstallmentLoans()
    }

}