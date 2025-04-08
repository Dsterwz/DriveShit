package com.sheet.drivenext

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class DetailsFragment : Fragment() {
    private lateinit var favouriteButton: ImageButton
    private lateinit var carImage: ImageView
    private lateinit var catTitle: TextView
    private lateinit var carAddress: TextView
    private lateinit var carDescription: TextView
    private lateinit var carPrice: TextView
    private lateinit var rentButton: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_details, container, false)

        favouriteButton = view.findViewById(R.id.favourite_button)
        rentButton = view.findViewById(R.id.rent_details_button)
        catTitle = view.findViewById(R.id.car_detail_title)
        carAddress = view.findViewById(R.id.car_address)
        carDescription = view.findViewById(R.id.car_description)
        carPrice = view.findViewById(R.id.car_details_price)
        carImage = view.findViewById(R.id.car_picture)

        rentButton.setOnClickListener(View.OnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, CheckoutFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        })

        return view
    }

}