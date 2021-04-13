package com.example.mvvmexampleapplication.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexampleapplication.R
import com.example.mvvmexampleapplication.databinding.ActivityLoginBinding
import com.example.mvvmexampleapplication.interfaces.LoginResultCallBack
import com.example.mvvmexampleapplication.ui.cars.CarsActivity
import com.example.mvvmexampleapplication.utils.toast


class LoginActivity : AppCompatActivity(), LoginResultCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = ViewModelProvider(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String) {
        toast(message)
    }

    override fun onError(message: String) {
        toast(message)
    }
}