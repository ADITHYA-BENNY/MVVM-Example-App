package com.example.mvvmexampleapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexampleapplication.R
import com.example.mvvmexampleapplication.databinding.CarsBinding
import com.example.mvvmexampleapplication.models.Car
import kotlinx.android.synthetic.main.car.view.*

class CarsAdapter(
    private val cars: List<Car>
) : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car,parent,false)
        return CarsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.itemView.car_model_name.text = cars[position].modelName
        holder.itemView.car_model_year.text = cars[position].modelYear
        holder.itemView.car_index.text = cars[position].index.toString()
    }

    override fun getItemCount() = cars.size

    inner class CarsViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView)
}