package com.sheet.drivenext

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class OnboardingFragment1 : Fragment() {
    private lateinit var button: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_onboarding1, container, false)
        button = view.findViewById(R.id.onboarding1_button)
        // button.setOnClickListener { getViewPager()}
        return view

    }

}