package com.example.cashadvances.domain.repositories

import com.example.cashadvances.domain.entities.CalculatePercent

interface CalculateRepository {

    fun getCalculatePercent(): CalculatePercent

}