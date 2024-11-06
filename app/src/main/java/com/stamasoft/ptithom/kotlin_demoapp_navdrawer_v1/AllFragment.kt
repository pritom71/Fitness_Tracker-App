package com.stamasoft.ptithom.kotlin_demoapp_navdrawer_v1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView

class AllFragment : Fragment() {

    private val exerciseTitles = arrayOf(
        "Burpees",
        "Mountain Climbers",
        "Jumping Jacks",
        "High Knees",
        "Squat to Press",
        "Lunge with Twist",
        "Push-Up to Row",
        "Deadlift to Upright Row",
        "Plank to Push-Up",
        "Dumbbell Clean and Press",
        "Tuck Jumps",
        "Renegade Rows",
        "Thrusters"
    )

    private val exerciseTime = arrayOf(
        "30 mins",
        "60 mins",
        "60 mins",
        "30 mins",
        "Lunges",
        "30 mins",
        "30 mins",
        "60 mins",
        "60 mins",
        "30 mins",
        "60 mins",
        "30 mins",
        "60 mins"
    )

    private val exerciseType = arrayOf(
        "Beginner",
        "Intermediate",
        "Intermediate",
        "Beginner",
        "Beginner",
        "Intermediate",
        "Beginner",
        "Beginner",
        "Beginner",
        "Intermediate",
        "Intermediate",
        "Beginner",
        "Intermediate"
    )

    private val exerciseImageIds = intArrayOf(
        R.drawable.ex1,
        R.drawable.ex2,
        R.drawable.ex3,
        R.drawable.ex4,
        R.drawable.ex5,
        R.drawable.ex6,
        R.drawable.ex7,
        R.drawable.ex8,
        R.drawable.ex9,
        R.drawable.ex10,
        R.drawable.ex11,
        R.drawable.ex12,
        R.drawable.ex13
    ).toTypedArray() // Convert IntArray to Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all, container, false)

        // Find the ListView in the inflated layout
        val listView = view.findViewById<ListView>(R.id.listView)

        // Create and set the adapter
        val myListAdapter = MyListAdapter(requireActivity(), exerciseTitles, exerciseTime, exerciseType, exerciseImageIds)
        listView.adapter = myListAdapter

        // Set the item click listener
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Log.d("AllFragment", "Item clicked: $position")
            Log.d("AllFragment", "Title: ${exerciseTitles[position]}")
            Log.d("AllFragment", "Time: ${exerciseTime[position]}")
            Log.d("AllFragment", "Type: ${exerciseType[position]}")
            Log.d("AllFragment", "Image ID: ${exerciseImageIds[position]}")

            val detailFragment = DetailFragment().apply {
                arguments = Bundle().apply {
                    putString("EXERCISE_TITLE", exerciseTitles[position])
                    putString("EXERCISE_TIME", exerciseTime[position])
                    putString("EXERCISE_TYPE", exerciseType[position])
                    putInt("EXERCISE_IMAGE_ID", exerciseImageIds[position])
                }
            }

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
