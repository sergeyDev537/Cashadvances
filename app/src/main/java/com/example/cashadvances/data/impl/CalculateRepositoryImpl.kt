package com.example.cashadvances.data.impl

import com.example.cashadvances.domain.entities.CalculatePercent
import com.example.cashadvances.domain.repositories.CalculateRepository

object CalculateRepositoryImpl : CalculateRepository {

    override fun getCalculatePercent(
        loanAmount: String,
        loanTerm: String,
        interestRate: String
    ): CalculatePercent {
        val loanAmountInt: Int = loanAmount.toInt()
        val loanTermInt: Int = loanTerm.toInt()
        val interestRateInt: Int = interestRate.toInt()
        val totalInterestLoanCalc = loanAmountInt * interestRateInt / 100 / 31 * loanTermInt
        val totalPaymentsLoanCalc = loanAmountInt + totalInterestLoanCalc
        val paymentEveryMonthLoanCalc = totalPaymentsLoanCalc / loanTermInt
        return CalculatePercent(
            paymentEveryMonthLoanCalc, totalPaymentsLoanCalc, totalInterestLoanCalc
        )
    }
}