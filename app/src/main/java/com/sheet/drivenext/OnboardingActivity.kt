package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton


class OnboardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: OnboardingPagerAdapter
    private lateinit var buttonNext: MaterialButton
    private lateinit var buttonEnroll: MaterialButton
    private lateinit var buttonSkip: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)
        init()
    }


    private fun init() {
        adapter = OnboardingPagerAdapter(this)
        viewPager = findViewById(R.id.onboarding_pager)
        viewPager.adapter = adapter

        buttonNext = findViewById(R.id.onboarding_next_button)
        buttonEnroll = findViewById(R.id.onboarding_enroll_button)
        buttonSkip = findViewById(R.id.onboarding_skip_button)

        buttonNext.setOnClickListener(View.OnClickListener {
            viewPager.currentItem += 1
            if (viewPager.currentItem == ONBOARDING_PAGES_NUM - 1) {
                buttonEnroll.visibility = View.VISIBLE
                buttonNext.visibility = View.GONE
            }
        })
        buttonEnroll.setOnClickListener(View.OnClickListener {
            val i = Intent(this, StartActivity::class.java)
            startActivity(i)
        })
        buttonSkip.setOnClickListener(View.OnClickListener {
            val i = Intent(this, StartActivity::class.java)
            startActivity(i)
        })


    }
}