package com.sheet.drivenext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyRentsFragment : Fragment(), OnItemClickListener {
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: RentsPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_my_rents, container, false)

        recycler = view.findViewById(R.id.rents_recycler)

        val itemList = listOf(
            RentItem("Mercedes-Benz S 500 Sedan", "Начало аренды: 08:00, 27 сентября 2024"),
            RentItem("Audi A4", "Аренда отменена, 17 сентября 2024"),
            RentItem("BMW 3 Series", "Аренда завершена, 22 сентября 2024"),
        )

        adapter = RentsPagerAdapter(itemList, this)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = adapter

        return view
    }

    override fun onItemClick(position: Int) {
        val selectedItem = (recycler.adapter as RentsPagerAdapter).itemList[position]
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, RentDetailsFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}