package com.sheet.drivenext

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


const val ARG_ONBOARDING_TITLE = "onboarding_title"
const val ARG_ONBOARDING_TEXT = "onboarding_text"
const val ARG_ONBOARDING_IMAGE = "onboarding_image"


class OnboardingFragment : Fragment() {
    private lateinit var textView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var imageView: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf {
            it.containsKey(ARG_ONBOARDING_TITLE)
        }?.apply {
            titleTextView = view.findViewById(R.id.onboarding_title)
            textView = view.findViewById(R.id.onboarding_text)
            imageView = view.findViewById(R.id.onboarding_image)

            titleTextView.text = resources.getString(getInt(ARG_ONBOARDING_TITLE))
            textView.text = resources.getString(getInt(ARG_ONBOARDING_TEXT))
            imageView.setImageResource(getInt(ARG_ONBOARDING_IMAGE))
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(onboardingTitle: Int, onboardingText: Int, onboardingImage: Int) =
            OnboardingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ONBOARDING_TITLE, onboardingTitle)
                    putInt(ARG_ONBOARDING_TEXT, onboardingText)
                    putInt(ARG_ONBOARDING_IMAGE, onboardingImage)
                }
            }
    }
}