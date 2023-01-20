package com.example.cashadvances.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cashadvances.data.impl.CalculateRepositoryImpl
import com.example.cashadvances.domain.entities.CalculatePercent
import com.example.cashadvances.domain.usecases.GetCalculatePercentUseCase

class CalculateViewModel : ViewModel() {

    private var calculateRepository = CalculateRepositoryImpl

    private var getCalculatePercentUseCase = GetCalculatePercentUseCase(calculateRepository)

    private var _calculatePercents = MutableLiveData<CalculatePercent>()
    val calculatePercents: LiveData<CalculatePercent>
        get() = _calculatePercents

    fun calculatePercent(
        loanAmount: String,
        loanTerm: String,
        interestRate: String
    ) {
        val loanAmountInt = parseData(loanAmount)
        val loanTermInt = parseData(loanTerm)
        val interestRateInt = parseData(interestRate)
        _calculatePercents.value =
            getCalculatePercentUseCase.invoke(loanAmountInt, loanTermInt, interestRateInt)
    }

    private fun parseData(string: String):Int{
        return if (string.isNotEmpty()){
            string.toInt()
        } else{
            0
        }
    }

}