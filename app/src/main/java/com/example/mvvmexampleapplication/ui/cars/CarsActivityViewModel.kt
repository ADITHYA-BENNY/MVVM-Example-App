package com.example.mvvmexampleapplication.ui.cars

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexampleapplication.models.Car
import com.example.mvvmexampleapplication.models.Cars
import com.example.mvvmexampleapplication.repositories.CarRepository
import com.example.mvvmexampleapplication.utils.Coroutines
import com.google.gson.Gson
import kotlinx.coroutines.Job
import java.io.IOException
import java.nio.charset.Charset

class CarsActivityViewModel(
        private val repository: CarRepository,
        private val context: Context
) : ViewModel() {
    class CarsActivityViewModel(
            private val repository: CarRepository,
            private val context: Context
    ) : ViewModel() {

        private lateinit var job: Job
        private val _cars = MutableLiveData<List<Car>>()
        val cars: LiveData<List<Car>>
            get() = _cars

        fun getCars() {
            job = Coroutines.ioThenMain(
                    {val cars = repository.getCars()},
                    {_cars.value = repository.getCars()}
            )
        }

        override fun onCleared() {
            super.onCleared()
            if (::job.isInitialized) job.cancel()
        }
    }
}