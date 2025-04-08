package com.sheet.drivenext

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RentsPagerAdapter (val itemList: List<RentItem>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<RentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rent_item_layout, parent, false)
        return RentsViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: RentsViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.rentCarName.text = currentItem.title
        holder.rentStatus.text = currentItem.status
    }

    override fun getItemCount() = itemList.size
}
