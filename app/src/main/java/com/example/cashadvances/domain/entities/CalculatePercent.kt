package com.example.cashadvances.domain.entities

data class CalculatePercent(
    val paymentEveryMonth: Int,
    val totalPayments: Int,
    val totalInterest: Int
)