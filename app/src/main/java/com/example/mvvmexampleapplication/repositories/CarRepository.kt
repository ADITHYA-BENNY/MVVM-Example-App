package com.example.mvvmexampleapplication.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmexampleapplication.data.CarsApi
import com.example.mvvmexampleapplication.data.SafeApiRequest
import com.example.mvvmexampleapplication.models.Car
import com.example.mvvmexampleapplication.models.Cars
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarRepository(
        private val api: CarsApi
) {
    fun getCars(): LiveData<Cars> {
        val itemResponse = MutableLiveData<Cars>()

        api.getCars("media", "1d3642ef-24de-4a95-8db6-7ea1e35fe2db")
            .enqueue(object : Callback<Cars> {
                override fun onResponse(call: Call<Cars>, response: Response<Cars>) {
                    if (!response.isSuccessful) {
                        Log.d("", "1${response.code().toString()}")
                        return
                    }
                    itemResponse.value = response.body()
                }

                override fun onFailure(call: Call<Cars>, t: Throwable) {
                    Log.d("", "2 ${t.message!!}")
                }

            })
        return itemResponse
    }
}