package com.example.cashadvances.domain.usecases

import android.content.Context
import com.example.cashadvances.domain.entities.LanguageItem
import com.example.cashadvances.domain.repositories.LanguageRepository

class GetListLanguageUseCase(private val languageRepository: LanguageRepository) {

    operator fun invoke(context: Context): List<LanguageItem> {
        return languageRepository.getListLanguage(context)
    }

}