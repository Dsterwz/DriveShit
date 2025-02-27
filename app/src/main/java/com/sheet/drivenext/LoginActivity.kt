package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton


class LoginActivity : AppCompatActivity() {
    private lateinit var buttonForgot: MaterialButton
    private lateinit var buttonLogin: MaterialButton
    private lateinit var buttonLoginGoogle: MaterialButton
    private lateinit var buttonSignUp: MaterialButton
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() {
        editTextEmail = findViewById(R.id.edit_email)
        editTextPassword = findViewById(R.id.edit_password)

        buttonLogin = findViewById(R.id.button_login)
        buttonLoginGoogle = findViewById(R.id.button_google_login)
        buttonSignUp = findViewById(R.id.button_sign_up)
        buttonForgot = findViewById(R.id.button_forgot)


        fun CharSequence?.isValidEmail() =
            !isNullOrEmpty() and Patterns.EMAIL_ADDRESS.matcher(this).matches()


        editTextEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isValidEmail()) {
                    editTextEmail.error = getString(R.string.enter_correct_email)
                }
                buttonLogin.isEnabled =
                    editTextEmail.text.toString().trim().isValidEmail() and !TextUtils.isEmpty(
                        editTextPassword.text.toString().trim()
                    )
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    editTextPassword.error = getString(R.string.enter_password)
                }

                buttonLogin.isEnabled =
                    editTextEmail.text.toString().trim().isValidEmail() and !TextUtils.isEmpty(
                        editTextPassword.text.toString().trim()
                    )
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        val email: String = editTextEmail.text.toString().trim()
        val password: String = editTextPassword.text.toString().trim()
        buttonLogin.setOnClickListener(View.OnClickListener {
            // запрос
            Log.d("myLogs", "Email: $email\nPassword: $password")
        })

        buttonLoginGoogle.setOnClickListener(View.OnClickListener {
            // запрос гугл
            Log.d("myLogs", "Google")

        })

        buttonSignUp.setOnClickListener(View.OnClickListener {
            val i: Intent = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        })

        buttonForgot.setOnClickListener(View.OnClickListener {
            Log.d("myLogs", "Forgot password")
        })

    }
}