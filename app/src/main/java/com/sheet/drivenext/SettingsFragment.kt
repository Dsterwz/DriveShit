package com.sheet.drivenext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton


class SettingsFragment : Fragment(), OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonProfile: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_settings, container, false)

        recyclerView = view.findViewById(R.id.settings_recycler)
        buttonProfile = view.findViewById(R.id.settings_profile_button)


        val itemList = listOf(
            SettingsItem(R.drawable.outline_car_rental_24, getString(R.string.my_rents)),
            SettingsItem(R.drawable.baseline_brightness_5_24, getString(R.string.theme)),
            SettingsItem(R.drawable.notification, getString(R.string.notifications)),
            SettingsItem(R.drawable.outline_car_rental_24, getString(R.string.attach_car)),
            SettingsItem(R.drawable.outline_contact_support_24, getString(R.string.support)),
            SettingsItem(R.drawable.outline_contact_mail_24, getString(R.string.invite))
        )

        val adapter = SettingsRecyclerAdapter(itemList, this)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        buttonProfile.setOnClickListener(View.OnClickListener {
            loadFragment(ProfileFragment())
        })

        return view
    }

    override fun onItemClick(position: Int) {
        val selectedItem = (recyclerView.adapter as SettingsRecyclerAdapter).itemList[position]
        when (selectedItem.title) {
            getString(R.string.my_rents) -> {
                loadFragment(MyRentsFragment())
            }

            getString(R.string.attach_car) -> {
            }

            getString(R.string.theme) -> run {
                loadFragment(SettingsSubMenuFragment())
            }

            getString(R.string.notifications) -> run {
                loadFragment(SettingsSubMenuFragment())
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}