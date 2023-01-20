package com.example.cashadvances.domain.usecases

import com.example.cashadvances.domain.entities.KeyItem
import com.example.cashadvances.domain.repositories.KeyRepository

class GetVisibleKeyUseCase(private val keyRepository: KeyRepository) {

    suspend operator fun invoke(): KeyItem{
        return keyRepository.getVisibleKey()
    }

}