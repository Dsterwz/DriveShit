package com.sheet.drivenext

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private var cars: List<Car> = emptyList()) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(carView: View) : RecyclerView.ViewHolder(carView) {
        val carImage: ImageView = carView.findViewById(R.id.car_image)
        val carTitle: TextView = carView.findViewById(R.id.car_title)
        val carBrand: TextView = carView.findViewById(R.id.car_brand)
        val carPrice: TextView = carView.findViewById(R.id.car_price)
        val carGearbox: TextView = carView.findViewById(R.id.car_gearbox)
        val carEnergy: TextView = carView.findViewById(R.id.car_energy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.car_item_layout, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = cars[position]
        val img: Uri = Uri.parse("android.resource://com.sheet.drivenext/"+currentItem.image)
        holder.carTitle.text = currentItem.title
        holder.carBrand.text = currentItem.brand
        holder.carPrice.text = String.format(currentItem.price.toString())
        holder.carGearbox.text = currentItem.gearbox
        holder.carEnergy.text = currentItem.energy
        holder.carImage.setImageURI(img)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    fun setData(newCars: List<Car>) {
        cars = newCars
        notifyDataSetChanged()
    }
}
