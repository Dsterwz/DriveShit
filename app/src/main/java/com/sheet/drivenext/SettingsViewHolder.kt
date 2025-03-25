package com.sheet.drivenext

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SettingsViewHolder(itemView: View, private val listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener  {
    val itemImage: ImageView = itemView.findViewById(R.id.settings_item_image)
    val itemTitle: TextView = itemView.findViewById(R.id.settings_item_title)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        listener.onItemClick(adapterPosition)
    }
}

interface OnItemClickListener {
    fun onItemClick(position: Int)
}
