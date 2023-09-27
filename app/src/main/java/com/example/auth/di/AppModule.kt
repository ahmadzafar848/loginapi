package com.example.auth.di

import LoginRepository
import com.example.auth.network.ApiClient
import com.example.auth.viewmodels.LoginViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { ApiClient(androidApplication()).getInstance() }
    single { LoginRepository(get()) }
    viewModel { LoginViewModel(get()) }
}