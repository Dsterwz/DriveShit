package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton

//private const val CLIENT_ID = "780579203553-em5br64khgsgqmo57d942mt9aubu4gf7.apps.googleusercontent.com"

class LoginActivity : AppCompatActivity() {

    private lateinit var buttonForgot: MaterialButton
    private lateinit var buttonLogin: MaterialButton
    private lateinit var buttonLoginGoogle: MaterialButton
    private lateinit var buttonSignUp: MaterialButton

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

    private lateinit var toggleButton: ToggleButton
    private lateinit var gso: GoogleSignInOptions
    private lateinit var gsc: GoogleSignInClient

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
        editTextEmail = findViewById(R.id.edit_login_email)
        editTextPassword = findViewById(R.id.edit_login_password)

        buttonLogin = findViewById(R.id.button_login)
        buttonLoginGoogle = findViewById(R.id.button_google_login)
        buttonSignUp = findViewById(R.id.button_sign_up)
        buttonForgot = findViewById(R.id.button_forgot)

        toggleButton = findViewById(R.id.login_toggle_password)

        fun CharSequence?.isValidEmail() =
            !isNullOrEmpty() and Patterns.EMAIL_ADDRESS.matcher(this).matches()

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editTextPassword.inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
            } else {
                editTextPassword.inputType =
                    (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            }
        }

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

        gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        gsc = GoogleSignIn.getClient(this, gso)

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val i: Intent = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        }

        buttonLoginGoogle.setOnClickListener(View.OnClickListener {
            val signInIntent: Intent = gsc.getSignInIntent()
            startActivity(signInIntent)
        })

        buttonSignUp.setOnClickListener(View.OnClickListener {
            val i: Intent = Intent(this, SignUpActivity::class.java)
            startActivity(i)
        })

        buttonForgot.setOnClickListener(View.OnClickListener {
            Log.d("myLogs", "Forgot password")
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                task.getResult(ApiException::class.java)
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: ApiException) {
                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}