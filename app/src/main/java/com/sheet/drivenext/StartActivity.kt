package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class StartActivity : AppCompatActivity() {
    private lateinit var buttonStartLogin: MaterialButton
    private lateinit var buttonStartSignUp: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }


    private fun init() {
        buttonStartLogin = findViewById(R.id.button_start_login)
        buttonStartSignUp = findViewById(R.id.button_start_sign_up)

        buttonStartLogin.setOnClickListener(View.OnClickListener {
            val i: Intent = Intent(this, LoginActivity::class.java)
            startActivity(i)
        })

        buttonStartSignUp.setOnClickListener(View.OnClickListener {
            val i: Intent = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        })
    }
}