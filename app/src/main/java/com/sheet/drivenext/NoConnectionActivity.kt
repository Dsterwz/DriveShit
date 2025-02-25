package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class NoConnectionActivity : AppCompatActivity() {
    private lateinit var button: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_no_connection)
        checkConnection()
    }


    private fun checkConnection() {
        button = findViewById(R.id.no_connection_button)
        button.setOnClickListener {
            if (isOnline()) {
                val i = Intent(this, OnboardingActivity::class.java)
                startActivity(i)
            }
        }
    }
}