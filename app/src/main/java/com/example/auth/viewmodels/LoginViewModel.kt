package com.example.auth.viewmodels

import LoginRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.models.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private val _loginResponse = MutableLiveData<Response<LoginResponse>>()
    val loginResponse: LiveData<Response<LoginResponse>> = _loginResponse

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val response = loginRepository.login(email, password)
            _loginResponse.postValue(response)
        }
    }
}
