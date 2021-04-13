package com.example.mvvmexampleapplication.models

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable

class User(
    private var email: String,
    private var password: String
) : BaseObservable() {
    val isDataValid: Boolean
    get() = (!TextUtils.isEmpty(getEmail()))
            && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()
            && getPassword().length > 6

    fun getPassword(): String {
        return password
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun setPassword(password: String) {
        this.password = password
    }
}