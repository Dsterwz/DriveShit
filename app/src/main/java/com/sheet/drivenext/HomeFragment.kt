package com.sheet.drivenext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(), OnCarClickListener {
    private lateinit var carRecycler: RecyclerView
    private lateinit var carSearch: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        carRecycler = view.findViewById(R.id.car_recycler)
        carSearch = view.findViewById(R.id.car_search)

        val itemList = listOf(
            CarItem(R.drawable.iris, "S 500 Sedan", "Mercedes-Benz", 2500, "A/T", "Бензин"),
            CarItem(R.drawable.iris, "S 500 Sedan", "Mercedes-Benz", 2500, "A/T", "Бензин"),
            CarItem(R.drawable.iris, "S 500 Sedan", "Mercedes-Benz", 2500, "A/T", "Бензин"),
        )

        val adapter = CarRecyclerAdapter(itemList, this)
        carRecycler.layoutManager = LinearLayoutManager(activity)
        carRecycler.adapter = adapter
        return view
    }

    override fun onRentButtonClick(position: Int) {
        val selectedItem = (carRecycler.adapter as CarRecyclerAdapter).itemList[position]
        Toast.makeText(
            activity,
            "Нажата кнопка элемента ${selectedItem.title}",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDetailsButtonClick(position: Int) {
        val selectedItem = (carRecycler.adapter as CarRecyclerAdapter).itemList[position]
        Toast.makeText(
            activity,
            "Нажата кнопка элемента ${selectedItem.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}