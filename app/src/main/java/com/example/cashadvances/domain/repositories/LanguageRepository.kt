package com.example.cashadvances.domain.repositories

import com.example.cashadvances.domain.entities.LanguageItem

interface LanguageRepository {

    fun getListLanguage(): List<LanguageItem>

    fun updateLanguage()

}