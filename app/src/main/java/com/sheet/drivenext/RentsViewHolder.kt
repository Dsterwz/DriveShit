package com.sheet.drivenext

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RentsViewHolder(itemView: View, private val listener: OnItemClickListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    val rentCarName: TextView = itemView.findViewById(R.id.rent_car_name)
    val rentStatus: TextView = itemView.findViewById(R.id.rent_status)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        listener.onItemClick(adapterPosition)
    }
}