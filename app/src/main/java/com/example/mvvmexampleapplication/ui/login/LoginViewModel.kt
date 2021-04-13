package com.example.mvvmexampleapplication.ui.login

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmexampleapplication.interfaces.LoginResultCallBack
import com.example.mvvmexampleapplication.models.User
import com.example.mvvmexampleapplication.ui.cars.CarsActivity


class LoginViewModel(
    private val listener: LoginResultCallBack
) : ViewModel() {
    private val user: User

    init {
        this.user = User("", "")
    }

    val emailTextWatcher: TextWatcher
    get() = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            user!!.setEmail(s.toString())
        }

    }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
            }

        }

    fun onLoginClicked(view: View) {
        if (user.isDataValid) {
            listener.onSuccess("Login Success")
            Intent(view.context, CarsActivity::class.java).also {
                view.context.startActivity(it)
            }
        } else
            listener.onError("Login Failed")
    }
}