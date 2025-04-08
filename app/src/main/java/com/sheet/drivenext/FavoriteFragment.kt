package com.sheet.drivenext

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FavoriteFragment : Fragment() {
    private lateinit var carDao: CarDao
    private lateinit var carRecycler: RecyclerView
    private lateinit var adapter: CarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_favorite, container, false)

        carRecycler = view.findViewById(R.id.favourite_recycler)
        carRecycler.layoutManager = LinearLayoutManager(activity)
        adapter = CarAdapter()
        carRecycler.adapter = adapter


        context?.let {
            carDao = CarDatabase.getDatabase(it.applicationContext).carDao()

            lifecycleScope.launch {
                carDao.getAllCars().collectLatest { cars ->
                    adapter.setData(cars)
                    Log.d("CarFragment", "Cars from DB: $cars")
                }
            }
        } ?: run {
            Log.e("CarFragment", "Context is null!")
        }

        lifecycleScope.launch {
            carDao.insert(
                Car(
                    1,
                    "S 500 Sedan",
                    "Mercedes-Benz",
                    2500,
                    "A/T",
                    "Бензин",
                    R.drawable.iris.toString(),
                )
            )
            carDao.insert(
                Car(
                    2,
                    "Multipla",
                    "Fiat",
                    9999,
                    "M/T",
                    "Бензин",
                    R.drawable.fiat.toString(),
                )
            )
        }

        return view
    }
}