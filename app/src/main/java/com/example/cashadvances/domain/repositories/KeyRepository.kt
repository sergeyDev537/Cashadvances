package com.example.cashadvances.domain.repositories

interface KeyRepository {

    suspend fun getVisibleKey(): String

}