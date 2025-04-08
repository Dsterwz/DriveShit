package com.sheet.drivenext

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton

class GoodLuckFragment : Fragment() {

    private lateinit var homeButton: MaterialButton
    private lateinit var rentsButton: MaterialButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_good_luck, container, false)

        homeButton = view.findViewById(R.id.button_to_home)
        rentsButton = view.findViewById(R.id.button_to_rents)

        homeButton.setOnClickListener(View.OnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, HomeFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        })

        rentsButton.setOnClickListener(View.OnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, MyRentsFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        })

        return view
    }

}