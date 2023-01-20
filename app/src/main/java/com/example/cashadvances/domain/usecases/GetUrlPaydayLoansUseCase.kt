package com.example.cashadvances.domain.usecases

import com.example.cashadvances.domain.repositories.PaydayLoansRepository

class GetUrlPaydayLoansUseCase(private val paydayLoansRepository: PaydayLoansRepository) {

    operator fun invoke(): String {
        return paydayLoansRepository.getUrlPaydayLoans()
    }

}