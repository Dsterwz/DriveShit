package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class OnboardingFragment3 : Fragment() {

    private lateinit var button: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_onboarding3, container, false)
        button = view.findViewById(R.id.onboarding3_button)
        button.setOnClickListener {
            val i = Intent(context, MainActivity::class.java)
            startActivity(i)
        }
        return view
    }
}