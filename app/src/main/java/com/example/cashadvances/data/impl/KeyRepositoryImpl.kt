package com.example.cashadvances.data.impl

import com.example.cashadvances.data.newtwork.Common
import com.example.cashadvances.domain.entities.KeyItem
import com.example.cashadvances.domain.repositories.KeyRepository

object KeyRepositoryImpl : KeyRepository {

    const val TYPE_VISIBLE = "ok"
    private const val TYPE_NOT_VISIBLE = "no"

    private val apiInterface = Common.apiInterface

    override suspend fun getVisibleKey(): KeyItem {
        return apiInterface.getVisibleKey().body() ?: KeyItem(
            TYPE_NOT_VISIBLE,
            "",
            ""
        )
    }
}