package com.example.cashadvances.data.impl

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.example.cashadvances.R
import com.example.cashadvances.domain.entities.LanguageItem
import com.example.cashadvances.domain.repositories.LanguageRepository

object LanguageRepositoryImpl: LanguageRepository {

    override fun getListLanguage(context: Context): List<LanguageItem> {
        return listOf(
            LanguageItem(
                context.getString(R.string.english),
                context.getString(R.string.gb)
            ),
            LanguageItem(
                context.getString(R.string.russian),
                context.getString(R.string.ru)
            ),
            LanguageItem(
                context.getString(R.string.spanish),
                context.getString(R.string.sp)
            ),
        )
    }

    override fun updateLanguage(codeLanguage: String) {
        val appLocale: LocaleListCompat =
            LocaleListCompat.forLanguageTags("ru")
        AppCompatDelegate.setApplicationLocales(appLocale)
    }
}