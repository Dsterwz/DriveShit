package com.sheet.drivenext

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import com.google.android.material.button.MaterialButton

class ProfileFragment : Fragment() {

    private lateinit var logoutButton: MaterialButton
    private lateinit var pfpButton: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        logoutButton = view.findViewById(R.id.logout_button)
        pfpButton = view.findViewById(R.id.pfp_change)

        logoutButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity, "Logged Out", Toast.LENGTH_SHORT).show()
        })

        pfpButton.setOnClickListener(View.OnClickListener {
            val i: Intent = Intent()
            i.setType("image/*")
            i.setAction(Intent.ACTION_GET_CONTENT)
            startActivity(Intent.createChooser(i, "Select Picture"))
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            childFragmentManager.commit {
                replace(R.id.fragment_container_profile, ProfileOptionsFragment())
            }
        }
    }
}