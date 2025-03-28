package com.sheet.drivenext

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class ProfileOptionsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.profile_preferences, rootKey)
    }
}