package com.sheet.drivenext

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SignUpPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = ONBOARDING_PAGES_NUM


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> SignUpFragment2()
            2 -> SignUpFragment3()
            else -> SignUpFragment1()
        }
    }
}
