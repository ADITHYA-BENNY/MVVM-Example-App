package com.example.mvvmexampleapplication.interfaces

interface LoginResultCallBack {
    fun onSuccess(message: String)
    fun onError(message: String)
}