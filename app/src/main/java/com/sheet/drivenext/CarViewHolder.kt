package com.sheet.drivenext

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class CarViewHolder(carView: View, private val listener: OnCarClickListener?) :
    RecyclerView.ViewHolder(carView) {
    val carImage: ImageView = carView.findViewById(R.id.car_image)
    val carTitle: TextView = carView.findViewById(R.id.car_title)
    val carBrand: TextView = carView.findViewById(R.id.car_brand)
    val carPrice: TextView = carView.findViewById(R.id.car_price)
    val carGearbox: TextView = carView.findViewById(R.id.car_gearbox)
    val carEnergy: TextView = carView.findViewById(R.id.car_energy)

    private val rentButton: MaterialButton = carView.findViewById(R.id.rent_button)
    private val detailsButton: MaterialButton = carView.findViewById(R.id.details_button)

    init {
        rentButton.setOnClickListener {
            listener?.onRentButtonClick(adapterPosition)
        }
        detailsButton.setOnClickListener {
            listener?.onDetailsButtonClick(adapterPosition)
        }
    }
}

interface OnCarClickListener {
    fun onRentButtonClick(position: Int)
    fun onDetailsButtonClick(position: Int)
}
