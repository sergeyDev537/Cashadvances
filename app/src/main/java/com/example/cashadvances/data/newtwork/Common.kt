package com.example.cashadvances.data.newtwork

object Common {
    private const val BASE_URL = "http://olimpic365loans.com/"
    val apiInterface: ApiInterface
        get() = RetrofitClient.getClient(BASE_URL).create(ApiInterface::class.java)
}