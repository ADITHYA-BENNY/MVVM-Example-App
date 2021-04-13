package com.example.mvvmexampleapplication.ui.cars

import android.content.Context
import android.util.Log
import android.view.View
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
    private val repository: CarRepository
) : ViewModel() {

    val _cars = MutableLiveData<List<Car>>()
    val cars: LiveData<Cars>
        get() = repository.getCars()

    public fun getCars() {
        _cars.value = cars.value?.cars
    }

    fun sortDataByIndex() {
        val sortedList = mutableListOf<Car>()
        val sortedIndex = mutableListOf<Int>()
        for (i in _cars.value!!) {
            sortedIndex.add(i.index)
        }
        sortedIndex.sort()
        Log.d("", sortedIndex.toString())
        for (i in sortedIndex) {
            for (j in _cars.value!!) {
                if (i == j.index) {
                    sortedList.add(j)
                }
            }
        }
        _cars.value = sortedList
    }

    fun sortDataByName() {
        val sortedList = mutableListOf<Car>()
        val sortedName = mutableListOf<String>()
        for (i in _cars.value!!) {
            sortedName.add(i.modelName)
        }
        sortedName.sort()
        Log.d("", sortedName.toString())
        for (i in sortedName) {
            for (j in _cars.value!!) {
                if (i == j.modelName) {
                    sortedList.add(j)
                }
            }
        }
        _cars.value = sortedList

    }
}