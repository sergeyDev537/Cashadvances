package com.example.cashadvances.data.impl

import com.example.cashadvances.data.newtwork.Common
import com.example.cashadvances.domain.repositories.KeyRepository

object KeyRepositoryImpl: KeyRepository {

    const val TYPE_VISIBLE = "ok"
    const val TYPE_NOT_VISIBLE = "no"

    private val apiInterface = Common.apiInterface

    override suspend fun getVisibleKey(): String {
        return apiInterface.getVisibleKey().body() ?: TYPE_NOT_VISIBLE
    }
}