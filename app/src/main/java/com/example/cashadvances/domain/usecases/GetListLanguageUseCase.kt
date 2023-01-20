package com.example.cashadvances.domain.usecases

import com.example.cashadvances.domain.entities.LanguageItem
import com.example.cashadvances.domain.repositories.LanguageRepository

class GetListLanguageUseCase(private val languageRepository: LanguageRepository) {

    operator fun invoke(): List<LanguageItem> {
        return languageRepository.getListLanguage()
    }

}