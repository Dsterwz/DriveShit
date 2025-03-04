package com.sheet.drivenext

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ToggleButton
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager


class SignUpFragment1 : SingUpBaseFragment() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPasswordConfirm: EditText

    private lateinit var togglePassword: ToggleButton
    private lateinit var togglePasswordConfirm: ToggleButton

    private lateinit var checkBox: CheckBox
    private lateinit var fragmentManager: FragmentManager
    private var fragmentListener: FragmentListener? = null

    private var isEmailFilled = false
    private var isPasswordFilled = false
    private var isPasswordConfirmFilled = false
    private var isChicked = false


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as? FragmentListener ?: throw ClassCastException(
            "$context must implement FragmentListener"
        )
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_sign_up1, container, false)
        editTextEmail = view.findViewById(R.id.edit_signup_email)
        editTextPassword = view.findViewById(R.id.edit_signup_password)
        editTextPasswordConfirm = view.findViewById(R.id.edit_signup_password_confirm)

        togglePassword = view.findViewById(R.id.signup_toggle_password)
        togglePasswordConfirm = view.findViewById(R.id.signup_toggle_password_confirm)

        checkBox = view.findViewById(R.id.checkbox_confidence)
        fragmentManager = requireActivity().supportFragmentManager

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
                editTextPasswordConfirm.inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
            } else {
                editTextPasswordConfirm.inputType =
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
                isEmailFilled = s.isValidEmail()
                fragmentListener?.onFragmentDataChanged(isValid())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s) and (count > 8)) {
                    editTextPassword.error = getString(R.string.enter_password)
                }
                isPasswordFilled = !TextUtils.isEmpty(s)
                fragmentListener?.onFragmentDataChanged(isValid())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        editTextPasswordConfirm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s) and (count > 8)) {
                    editTextPasswordConfirm.error = getString(R.string.enter_password)
                }
                isPasswordConfirmFilled = !TextUtils.isEmpty(s)
                fragmentListener?.onFragmentDataChanged(isValid())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        val email: String = editTextEmail.text.toString().trim()
        val password: String = editTextPassword.text.toString().trim()
        val passwordConfirm: String = editTextPasswordConfirm.text.toString().trim()

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            isChicked = isChecked
            fragmentListener?.onFragmentDataChanged(isValid())
        }

        fragmentListener?.onFragmentDataChanged(isValid())

        return view
    }

    override fun isValid(): Boolean {
        return isEmailFilled and isPasswordFilled and isPasswordConfirmFilled and isChicked
    }

    override fun onDetach() {
        super.onDetach()
        fragmentListener = null
    }
}