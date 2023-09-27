package com.example.auth.network

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient(androidApplication: Application)  {


    val chuckerInterceptor: ChuckerInterceptor = ChuckerInterceptor.Builder(androidApplication)
        .collector(ChuckerCollector(androidApplication))
        .build()

    // Initialize Retrofit with Chucker as an interceptor

    // Initialize Retrofit with Chucker as an interceptor
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(chuckerInterceptor)
        .build()

    fun getInstance(): ApiService {
        val retrofit =
            Retrofit.Builder().baseUrl("https://reqres.in").client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiService::class.java)
    }


}
