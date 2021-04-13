package com.example.mvvmexampleapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexampleapplication.R
import com.example.mvvmexampleapplication.databinding.CarsBinding
import com.example.mvvmexampleapplication.models.Car

class CarsAdapter(
    private val cars: List<Car>
) : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CarsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.car,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.carsBinding.car = cars[position]
    }

    override fun getItemCount() = cars.size

    inner class CarsViewHolder(
        val carsBinding: CarsBinding
    ) : RecyclerView.ViewHolder(carsBinding.root)
}