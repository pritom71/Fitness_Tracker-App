package com.stamasoft.ptithom.kotlin_demoapp_navdrawer_v1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        // Retrieve data from arguments
        val title = arguments?.getString("EXERCISE_TITLE")
        val time = arguments?.getString("EXERCISE_TIME")
        val type = arguments?.getString("EXERCISE_TYPE")
        val imageId = arguments?.getInt("EXERCISE_IMAGE_ID")

        // Find views in the layout
        val titleTextView = view.findViewById<TextView>(R.id.exerciseTitle)
        val timeTextView = view.findViewById<TextView>(R.id.exerciseTime)
        val typeTextView = view.findViewById<TextView>(R.id.exerciseType)
        val imageView = view.findViewById<ImageView>(R.id.exerciseImage)

        // Set data to views
        titleTextView.text = title
        timeTextView.text = time
        typeTextView.text = type
        imageId?.let { imageView.setImageResource(it) }

        return view
    }
}
