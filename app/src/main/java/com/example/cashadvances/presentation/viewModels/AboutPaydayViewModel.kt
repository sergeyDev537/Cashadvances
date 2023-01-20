package com.example.cashadvances.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cashadvances.data.impl.PaydayLoansRepositoryImpl
import com.example.cashadvances.domain.entities.QuestionAnswerItem
import com.example.cashadvances.domain.usecases.GetQuestionAnswerListUseCase
import kotlinx.coroutines.launch

class AboutPaydayViewModel: ViewModel() {

    private var listQuestions: List<QuestionAnswerItem> = arrayListOf()

    private var paydayLoansRepository = PaydayLoansRepositoryImpl

    private var getQuestionAnswerListUseCase = GetQuestionAnswerListUseCase(paydayLoansRepository)

    private var _questionList = MutableLiveData<List<QuestionAnswerItem>>()
    val questionList: LiveData<List<QuestionAnswerItem>>
        get() = _questionList

    private var _errorQuestionList = MutableLiveData<String>()
    val errorQuestionList: LiveData<String>
        get() = _errorQuestionList

    private var _answer = MutableLiveData<QuestionAnswerItem>()
    val answer: LiveData<QuestionAnswerItem>
        get() = _answer

    init {
        getQuestionList()
    }

    private fun getQuestionList(){
        viewModelScope.launch {
            try {
                listQuestions = getQuestionAnswerListUseCase.invoke()
                _questionList.value = listQuestions
            }
            catch (e: Exception){
                _errorQuestionList.value = e.message
            }
        }
    }

    fun getAnswerItem(nameQuestion: String){
        _answer.value = listQuestions.find { it.question ==  nameQuestion}
    }

}