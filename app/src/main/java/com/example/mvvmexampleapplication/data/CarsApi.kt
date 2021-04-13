package com.example.mvvmexampleapplication.data

import com.example.mvvmexampleapplication.models.Car
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CarsApi {

    @GET("cars%2Fcars.json?alt=media&token=803e0706-1458-4e02-bbc7-7109f82d02ff")
    fun getCars() : Response<List<Car>>

    companion object {
        operator fun invoke() : CarsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://firebasestorage.googleapis.com/v0/b/webstore-3fad3.appspot.com/o/")
                    .build()
                    .create(CarsApi::class.java)
        }
    }
}