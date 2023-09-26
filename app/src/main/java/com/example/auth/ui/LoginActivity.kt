package com.example.auth.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.auth.R
import com.example.auth.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val loginViewModel:LoginViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        handleLoginClickListener()


    }
    fun isEmailValid(email: String): Boolean {
        val regex = Regex("^\\S+@\\S+\\.\\S+\$")
        return regex.matches(email)
    }

    fun handleLoginClickListener(){
        val indicator=findViewById<ProgressBar>(R.id.cpIndicator)
        val btnLogin=findViewById<Button>(R.id.btnLogin)
        val etEmail=findViewById<EditText>(R.id.etEmail)
        val etPassword=findViewById<EditText>(R.id.etPassword)
        btnLogin.setOnClickListener {
            etEmail.text.trim()
            etPassword.text.trim()
            if (etEmail.text.isEmpty() || etPassword.text.isEmpty() ){
                Toast.makeText(this, "Email or Password is Empty", Toast.LENGTH_SHORT).show()
            }else if (!isEmailValid(etEmail.text.toString())){
                Toast.makeText(this, "Email is invalid", Toast.LENGTH_SHORT).show()
            }else{
                indicator.visibility=View.VISIBLE
                loginViewModel.login(etEmail.text.toString(),etPassword.text.toString())
            }

        }
        loginViewModel.loginResponse.observe(this, Observer {
            if (it.isSuccessful){
                val token=it.body()?.token
                Log.d("ahmad", "onCreate: ${token}")
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
            }else if(!it.isSuccessful){
                Log.d("ahmad", "onCreate: ${it.code()}")
                Toast.makeText(this, "Invalid Credits", Toast.LENGTH_SHORT).show()
            }
            indicator.visibility=View.INVISIBLE
        })
    }
}