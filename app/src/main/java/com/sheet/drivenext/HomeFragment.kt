package com.sheet.drivenext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(), OnCarClickListener {
    private lateinit var carRecycler: RecyclerView
    private lateinit var carSearch: SearchView
    private lateinit var adapter: CarRecyclerAdapter

    private var filteredList: ArrayList<CarItem> = ArrayList()
    private var itemList: ArrayList<CarItem> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        carRecycler = view.findViewById(R.id.car_recycler)
        carSearch = view.findViewById(R.id.car_search)

        itemList.add(CarItem(R.drawable.iris, "S 500 Sedan", "Mercedes-Benz", 2500, "A/T", "Бензин"))
        itemList.add(CarItem(R.drawable.iris, "S 500 Sedan", "Pukatti", 2500, "A/T", "Бензин"))
        itemList.add(CarItem(R.drawable.iris, "S 500 Sedan", "Mercedes-Benz", 2500, "A/T", "Бензин"))


        filteredList.addAll(itemList)

        adapter = CarRecyclerAdapter(filteredList, this)
        carRecycler.layoutManager = LinearLayoutManager(activity)
        carRecycler.adapter = adapter

        carSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText.orEmpty())
                return true
            }
        })

        return view
    }

    private fun filter(text: String) {
        filteredList.clear()
        if (text.isEmpty()) {
            filteredList.addAll(itemList)
        } else {
            for (item in itemList) {
                if (item.brand.toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item)
                }
            }
        }
        adapter.notifyDataSetChanged()
    }

    override fun onRentButtonClick(position: Int) {
        val selectedItem = (carRecycler.adapter as CarRecyclerAdapter).itemList[position]
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, CheckoutFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onDetailsButtonClick(position: Int) {
        val selectedItem = (carRecycler.adapter as CarRecyclerAdapter).itemList[position]
        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, DetailsFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}