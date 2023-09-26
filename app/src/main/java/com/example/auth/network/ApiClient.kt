package com.example.auth.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun getInstance(): ApiService {
        val retrofit =
            Retrofit.Builder().baseUrl("https://reqres.in").addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiService::class.java)
    }


}
