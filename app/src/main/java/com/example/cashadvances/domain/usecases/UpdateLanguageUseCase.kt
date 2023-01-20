package com.example.cashadvances.domain.usecases

import com.example.cashadvances.domain.repositories.LanguageRepository

class UpdateLanguageUseCase(private val languageRepository: LanguageRepository) {

    operator fun invoke(codeLanguage: String) {
        return languageRepository.updateLanguage(codeLanguage)
    }

}