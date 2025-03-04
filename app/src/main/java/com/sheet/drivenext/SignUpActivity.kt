package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class SignUpActivity : AppCompatActivity(), FragmentListener {
    private lateinit var pager: ViewPager2
    private lateinit var buttonBack: MaterialButton
    private lateinit var buttonNext: MaterialButton
    private lateinit var adapter: SignUpPagerAdapter
    private var fragmentValidity: MutableList<Boolean> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() {
        adapter = SignUpPagerAdapter(this)
        buttonBack = findViewById(R.id.button_back_login)
        buttonNext = findViewById(R.id.button_signup_next)
        pager = findViewById(R.id.signup_pager)

        pager.adapter = adapter
        pager.isUserInputEnabled = false
        buttonNext.isEnabled = false

        for (i in 0 until adapter.itemCount) {
            fragmentValidity.add(false)
        }

        buttonBack.setOnClickListener(View.OnClickListener {
            if (pager.currentItem == 0) {
                val i: Intent = Intent(this, StartActivity::class.java)
                startActivity(i)
            } else {
                pager.currentItem -= 1
            }
        })

        buttonNext.setOnClickListener(View.OnClickListener {
            val currentItem = pager.currentItem
            buttonNext.isEnabled = fragmentValidity[currentItem]
            if (currentItem == 2) {
                val i: Intent = Intent(this, SignUpFinishActivity::class.java)
                startActivity(i)
            } else {
                pager.currentItem += 1
            }
        })

    }

    override fun onFragmentDataChanged(isFragmentValid: Boolean) {
        val currentItem = pager.currentItem
        fragmentValidity[currentItem] = isFragmentValid
        buttonNext.isEnabled = fragmentValidity[currentItem]
    }

}