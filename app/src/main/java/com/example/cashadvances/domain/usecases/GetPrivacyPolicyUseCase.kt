package com.example.cashadvances.domain.usecases

import com.example.cashadvances.domain.repositories.PaydayLoansRepository

class GetPrivacyPolicyUseCase(private val paydayLoansRepository: PaydayLoansRepository) {

    operator fun invoke(): String {
        return paydayLoansRepository.getPrivacyPolicy()
    }

}