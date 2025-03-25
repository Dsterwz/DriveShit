package com.sheet.drivenext

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SettingsRecyclerAdapter(val itemList: List<SettingsItem>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<SettingsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.settings_item_layout, parent, false)
        return SettingsViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemImage.setImageResource(currentItem.imageResource)
        holder.itemTitle.text = currentItem.title
    }

    override fun getItemCount() = itemList.size
}
