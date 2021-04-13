package com.example.mvvmexampleapplication.data

import com.example.mvvmexampleapplication.models.Cars
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CarsApi {

    @GET("cars.json")
    fun getCars(
            @Query("alt") type : String,
            @Query("token") token : String
    ) : Call<Cars>

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