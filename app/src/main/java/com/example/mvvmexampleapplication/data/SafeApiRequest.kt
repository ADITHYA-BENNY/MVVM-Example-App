package com.example.mvvmexampleapplication.data

import com.example.mvvmexampleapplication.utils.ApiException
import retrofit2.Response

abstract class SafeApiRequest {
    fun<T: Any> apiRequest(call: () -> Response<T>) : T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw ApiException(response.code().toString())
        }
    }
}