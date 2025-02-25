package com.sheet.drivenext

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

const val ONBOARDING_PAGES_NUM = 3

class OnboardingPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    private val titles =
        listOf(R.string.onboarding1_title, R.string.onboarding2_title, R.string.onboarding3_title)
    private val texts =
        listOf(R.string.onboarding1_text, R.string.onboarding2_text, R.string.onboarding3_text)
    private val images =
        listOf(R.drawable.onboarding1, R.drawable.onboarding2, R.drawable.onboarding3)


    override fun getItemCount(): Int = ONBOARDING_PAGES_NUM


    override fun createFragment(position: Int): Fragment {
        val fragment = OnboardingFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_ONBOARDING_TITLE, titles[position])
            putInt(ARG_ONBOARDING_TEXT, texts[position])
            putInt(ARG_ONBOARDING_IMAGE, images[position])
        }
        return fragment
    }
}
