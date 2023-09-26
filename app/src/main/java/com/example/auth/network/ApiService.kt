package com.example.auth.network

import com.example.auth.models.LoginRequest
import com.example.auth.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}