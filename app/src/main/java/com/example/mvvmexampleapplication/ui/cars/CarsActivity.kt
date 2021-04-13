package com.example.mvvmexampleapplication.ui.cars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexampleapplication.R
import com.example.mvvmexampleapplication.adapters.CarsAdapter
import com.example.mvvmexampleapplication.data.CarsApi
import com.example.mvvmexampleapplication.databinding.ActivityCarsBinding
import com.example.mvvmexampleapplication.repositories.CarRepository
import kotlinx.android.synthetic.main.activity_cars.*

class CarsActivity : AppCompatActivity() {

    private lateinit var viewModel: CarsActivityViewModel
    private lateinit var factory: CarViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCarsBinding = DataBindingUtil.setContentView(this, R.layout.activity_cars)

        val api = CarsApi()
        val repository = CarRepository(api)
        factory = CarViewModelFactory(repository, this)
        viewModel = ViewModelProvider(this, factory).get(CarsActivityViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.getCars()
        viewModel.cars.observe(this, Observer { cars ->
            rv_cars.also {
                it.layoutManager = LinearLayoutManager(this)
                it.adapter = CarsAdapter(cars)
            }
        })
    }
}