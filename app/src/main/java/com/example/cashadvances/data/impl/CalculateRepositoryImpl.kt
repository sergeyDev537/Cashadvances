package com.example.cashadvances.data.impl

import com.example.cashadvances.domain.entities.CalculatePercent
import com.example.cashadvances.domain.repositories.CalculateRepository

object CalculateRepositoryImpl : CalculateRepository {

    override fun getCalculatePercent(
        loanAmount: Int,
        loanTerm: Int,
        interestRate: Int
    ): CalculatePercent {
        val totalInterestLoanCalc = loanAmount * interestRate / 100 / 31 * loanTerm
        val totalPaymentsLoanCalc = loanAmount + totalInterestLoanCalc
        val paymentEveryMonthLoanCalc = if (loanTerm == 0){
            totalPaymentsLoanCalc / 1
        }
        else{
            totalPaymentsLoanCalc / loanTerm
        }
        return CalculatePercent(
            paymentEveryMonthLoanCalc, totalPaymentsLoanCalc, totalInterestLoanCalc
        )
    }
}