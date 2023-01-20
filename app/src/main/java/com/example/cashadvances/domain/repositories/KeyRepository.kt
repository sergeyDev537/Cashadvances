package com.example.cashadvances.domain.repositories

import com.example.cashadvances.domain.entities.KeyItem

interface KeyRepository {

    suspend fun getVisibleKey(): KeyItem

}