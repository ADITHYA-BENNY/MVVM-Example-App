package com.example.mvvmexampleapplication.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexampleapplication.interfaces.LoginResultCallBack

class LoginViewModelFactory(
    private val listener: LoginResultCallBack
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}