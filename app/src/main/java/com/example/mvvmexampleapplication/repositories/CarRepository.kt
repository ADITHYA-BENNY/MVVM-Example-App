package com.example.mvvmexampleapplication.repositories

import com.example.mvvmexampleapplication.data.CarsApi
import com.example.mvvmexampleapplication.data.SafeApiRequest

class CarRepository(
        private val api: CarsApi
) : SafeApiRequest() {
    fun getCars() = apiRequest { api.getCars() }
}