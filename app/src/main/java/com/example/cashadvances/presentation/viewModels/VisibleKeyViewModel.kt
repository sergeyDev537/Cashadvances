package com.example.cashadvances.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cashadvances.data.impl.KeyRepositoryImpl
import com.example.cashadvances.domain.usecases.GetVisibleKeyUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VisibleKeyViewModel : ViewModel() {

    private var keyRepository = KeyRepositoryImpl

    private var getVisibleKeyUseCase = GetVisibleKeyUseCase(keyRepository)

    private var _visibleKey = MutableLiveData<Boolean>()
    val visibleKey: LiveData<Boolean>
        get() = _visibleKey

    private var _errorVisibleKey = MutableLiveData<String>()
    val errorVisibleKey: LiveData<String>
        get() = _errorVisibleKey

    init {
        getVisibleKey()
    }

    private fun getVisibleKey() {
        viewModelScope.launch {
            delay(3000)
            try {
                _visibleKey.value =
                    getVisibleKeyUseCase.invoke().debug_mode.contains(KeyRepositoryImpl.TYPE_VISIBLE)
            } catch (e: Exception) {
                _errorVisibleKey.value = e.message
            }

        }
    }

}