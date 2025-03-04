package com.sheet.drivenext

import androidx.fragment.app.Fragment

abstract class SingUpBaseFragment : Fragment() {
    abstract fun isValid(): Boolean
}