package com.sheet.drivenext

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import java.util.Calendar

class SignUpFragment2 : SingUpBaseFragment() {
    private lateinit var editTextLastName: EditText
    private lateinit var editTextFirstName: EditText
    private lateinit var editTextSurName: EditText
    private lateinit var editTextBirthDate: EditText
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton

    private var fragmentListener: FragmentListener? = null
    private var isFirstNameFilled = false
    private var isLastNameFilled = false
    private var isBirthDateFilled = false
    private var isSexChosen = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as? FragmentListener ?: throw ClassCastException(
            "$context must implement FragmentListener"
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_sign_up2, container, false)

        editTextLastName = view.findViewById(R.id.edit_lastname)
        editTextFirstName = view.findViewById(R.id.edit_firstname)
        editTextSurName = view.findViewById(R.id.edit_surname)
        editTextBirthDate = view.findViewById(R.id.edit_birthdate)

        radioMale = view.findViewById(R.id.radio_male)
        radioFemale = view.findViewById(R.id.radio_female)

        editTextLastName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    editTextLastName.error = getString(R.string.enter_lastname)
                }
                isLastNameFilled = !TextUtils.isEmpty(s)
                fragmentListener?.onFragmentDataChanged(isValid())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        editTextFirstName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    editTextFirstName.error = getString(R.string.enter_firstname)
                }
                isFirstNameFilled = !TextUtils.isEmpty(s)
                fragmentListener?.onFragmentDataChanged(isValid())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        editTextBirthDate.addTextChangedListener(DateMask())

        var sex: String = "business"
        val lastName: String = editTextLastName.text.toString().trim()
        val firstName: String = editTextFirstName.text.toString().trim()
        val surname: String? = editTextSurName.text.toString().trim()
        val birthdate: String = editTextBirthDate.text.toString().trim()

        radioMale.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sex = "male"
            }
            isSexChosen = true
            fragmentListener?.onFragmentDataChanged(isValid())
        }

        radioFemale.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sex = "female"
            }
            isSexChosen = true
            fragmentListener?.onFragmentDataChanged(isValid())
        }

        fragmentListener?.onFragmentDataChanged(isValid())

        return view
    }

    override fun isValid(): Boolean {
        isBirthDateFilled = editTextBirthDate.text.toString().trim().isNotEmpty()
        return isFirstNameFilled and isLastNameFilled and isSexChosen
    }

    override fun onDetach() {
        super.onDetach()
        fragmentListener = null
    }

}