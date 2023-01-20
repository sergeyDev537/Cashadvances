package com.example.cashadvances.domain.repositories

import android.content.Context
import com.example.cashadvances.domain.entities.LanguageItem

interface LanguageRepository {

    fun getListLanguage(context: Context): List<LanguageItem>

    fun updateLanguage(codeLanguage: String)

}