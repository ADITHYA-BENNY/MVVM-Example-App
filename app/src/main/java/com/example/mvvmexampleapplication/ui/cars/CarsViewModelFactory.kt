package com.example.mvvmexampleapplication.ui.cars

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexampleapplication.repositories.CarRepository

class CarViewModelFactory(
        private val repository: CarRepository,
        private val context: Context
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CarsActivityViewModel(repository, context) as T
    }
}