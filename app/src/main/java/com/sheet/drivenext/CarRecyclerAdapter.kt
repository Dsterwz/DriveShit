package com.sheet.drivenext

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CarRecyclerAdapter(val itemList: List<CarItem>, private val listener: OnCarClickListener) :
    RecyclerView.Adapter<CarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_item_layout, parent, false)
        return CarViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.carImage.setImageResource(currentItem.imageResource)
        holder.carTitle.text = currentItem.title
        holder.carBrand.text = currentItem.brand
        holder.carPrice.text = String.format(currentItem.price.toString())
        holder.carGearbox.text = currentItem.gearbox
        holder.carEnergy.text = currentItem.energy
    }

    override fun getItemCount() = itemList.size
}
