package com.sheet.drivenext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class RentDetailsFragment : Fragment() {

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
    private lateinit var status: TextView
    private lateinit var driverFullname: TextView
    private lateinit var licenseNumber: TextView
    private lateinit var cancelButton: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_rent_details, container, false)

        val car = CarItem(R.drawable.iris, "S 500 Sedan", "Mercedes-Benz", 2500, "A/T", "Бензин")

        carTitle = view.findViewById(R.id.car_rent_details_title)
        carImage = view.findViewById(R.id.car_rent_details_image)
        carBrand = view.findViewById(R.id.car_rent_details_brand)
        carPrice = view.findViewById(R.id.car_rent_details_price)

        carAddress = view.findViewById(R.id.rent_details_address)
        rentStart = view.findViewById(R.id.rent_details_start)
        rentEnd = view.findViewById(R.id.rent_details_end)
        driverFullname = view.findViewById(R.id.rent_details_fullname)
        licenseNumber = view.findViewById(R.id.rent_details_license)
        status = view.findViewById(R.id.rent_details_status)

        carRent = view.findViewById(R.id.rent_details_amount)
        insurance = view.findViewById(R.id.rent_insurance_amount)
        total = view.findViewById(R.id.rent_total)

        cancelButton = view.findViewById(R.id.cancel_rent)

        carTitle.text = car.title
        carBrand.text = car.brand
        carPrice.text = String.format(car.price.toString())
        carImage.setImageResource(car.imageResource)

        cancelButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "Canceled!", Toast.LENGTH_SHORT).show()
        })
        return view
    }

}