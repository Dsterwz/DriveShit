package com.sheet.drivenext

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton

class SignUpFragment2 : Fragment() {
    private lateinit var editTextLastName: EditText
    private lateinit var editTextFirstName: EditText
    private lateinit var editTextSurName: EditText
    private lateinit var editTextBirthDate: EditText
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_sign_up2, container, false)

//        editTextLastName = view.findViewById(R.id.)
        return view
    }

}