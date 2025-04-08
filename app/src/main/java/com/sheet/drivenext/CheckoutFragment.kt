package com.sheet.drivenext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton


class CheckoutFragment : Fragment() {
    private lateinit var rentStart: TextView
    private lateinit var rentEnd: TextView
    private lateinit var carAddress: TextView
    private lateinit var carRent: TextView
    private lateinit var insurance: TextView
    private lateinit var carImage: ImageView
    private lateinit var carTitle: TextView
    private lateinit var carBrand: TextView
    private lateinit var carPrice: TextView
    private lateinit var total: TextView
    private lateinit var deposit: TextView
    private lateinit var nextButton: MaterialButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_checkout, container, false)

        val car = CarItem(R.drawable.iris, "S 500 Sedan", "Mercedes-Benz", 2500, "A/T", "Бензин")

        rentStart = view.findViewById(R.id.rent_start)
        rentEnd = view.findViewById(R.id.rent_end)
        rentEnd = view.findViewById(R.id.rent_end)
        carTitle = view.findViewById(R.id.car_rent_title)
        carImage = view.findViewById(R.id.car_rent_image)
        carBrand = view.findViewById(R.id.car_rent_brand)
        carPrice = view.findViewById(R.id.car_rent_price)
        carAddress = view.findViewById(R.id.car_rent_address)
        carRent = view.findViewById(R.id.rent_amount)
        insurance = view.findViewById(R.id.insurance_amount)
        total = view.findViewById(R.id.total_price)
        deposit = view.findViewById(R.id.deposit)
        nextButton = view.findViewById(R.id.next_checkout_button)

        carTitle.text = car.title
        carBrand.text = car.brand
        carPrice.text = String.format(car.price.toString())
        carImage.setImageResource(car.imageResource)

        nextButton.setOnClickListener(View.OnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, GoodLuckFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        })

        return view
    }

}