package com.sheet.drivenext

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton


class SignUpFragment3 : SingUpBaseFragment() {
    private lateinit var editTextDriverLicense: EditText
    private lateinit var editTextDriverLicenseDate: EditText

    private lateinit var imageAvatar: ImageButton
    private lateinit var imageDriverLicense: ImageButton
    private lateinit var imagePassport: ImageButton

    private var fragmentListener: FragmentListener? = null
    private var isDriverLicenseFilled = false
    private var isDriverLicenseAttached = false
    private var isPassportAttached = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as? FragmentListener ?: throw ClassCastException(
            "$context must implement FragmentListener"
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_sign_up3, container, false)
        editTextDriverLicense = view.findViewById(R.id.edit_driver_license)
        editTextDriverLicenseDate = view.findViewById(R.id.edit_license_date)

        imageAvatar = view.findViewById(R.id.attach_avatar)
        imageDriverLicense = view.findViewById(R.id.image_driver_license)
        imagePassport = view.findViewById(R.id.image_passport)

        editTextDriverLicense.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (TextUtils.isEmpty(s)) {
                    editTextDriverLicense.error = getString(R.string.enter_password)
                }
                isDriverLicenseFilled = !TextUtils.isEmpty(s)
                fragmentListener?.onFragmentDataChanged(isValid())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        editTextDriverLicenseDate.addTextChangedListener(DateMask())

        imageAvatar.setOnClickListener(View.OnClickListener {
            val i: Intent = Intent()
            i.setType("image/*")
            i.setAction(Intent.ACTION_GET_CONTENT)
            startActivity(Intent.createChooser(i, "Select Picture"))
        })

        imageDriverLicense.setOnClickListener(View.OnClickListener {
            val i: Intent = Intent()
            i.setType("image/*")
            i.setAction(Intent.ACTION_GET_CONTENT)
            startActivity(Intent.createChooser(i, "Select Driver License"))
            isDriverLicenseAttached = true
            fragmentListener?.onFragmentDataChanged(isValid())
        })

        imagePassport.setOnClickListener(View.OnClickListener {
            val i: Intent = Intent()
            i.setType("image/*")
            i.setAction(Intent.ACTION_GET_CONTENT)
            startActivity(Intent.createChooser(i, "Select Passport"))
            isPassportAttached = true
            fragmentListener?.onFragmentDataChanged(isValid())
        })

        fragmentListener?.onFragmentDataChanged(isValid())

        return view
    }


    override fun isValid(): Boolean {
        return editTextDriverLicenseDate.text.toString().trim()
            .isNotEmpty() and isDriverLicenseFilled and isDriverLicenseAttached and isPassportAttached
    }


    override fun onDetach() {
        super.onDetach()
        fragmentListener = null
    }


}