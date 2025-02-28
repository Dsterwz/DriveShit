package com.sheet.drivenext

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ToggleButton

class SignUpFragment1 : Fragment() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPasswordConfirm: EditText

    private lateinit var togglePassword: ToggleButton
    private lateinit var togglePasswordConfirm: ToggleButton


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_sign_up1, container, false)
        editTextEmail = view.findViewById(R.id.edit_signup_email)
        editTextPassword = view.findViewById(R.id.edit_signup_password)
        editTextPasswordConfirm = view.findViewById(R.id.edit_signup_password_confirm)

        togglePassword = view.findViewById(R.id.signup_toggle_password)
        togglePasswordConfirm = view.findViewById(R.id.signup_toggle_password_confirm)

        fun CharSequence?.isValidEmail() =
            !isNullOrEmpty() and Patterns.EMAIL_ADDRESS.matcher(this).matches()

        togglePassword.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editTextPassword.inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
            } else {
                editTextPassword.inputType =
                    (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
            }
        }

        togglePasswordConfirm.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                togglePasswordConfirm.inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
            } else {
                togglePasswordConfirm.inputType =
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
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        editTextPasswordConfirm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    editTextPasswordConfirm.error = getString(R.string.enter_password)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        val email: String = editTextEmail.text.toString().trim()
        val password: String = editTextPassword.text.toString().trim()
        val passwordConfirm: String = editTextPasswordConfirm.text.toString().trim()

        return view
    }
}