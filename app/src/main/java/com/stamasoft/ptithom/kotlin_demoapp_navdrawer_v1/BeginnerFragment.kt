package com.stamasoft.ptithom.kotlin_demoapp_navdrawer_v1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BeginnerFragment : Fragment() {

    private val mNicolasCageMovies = listOf(
        ItemsViewModel_3(R.drawable.exe1, "Squats"),
        ItemsViewModel_3(R.drawable.exe2, "Pushups"),
        ItemsViewModel_3(R.drawable.exe3, "Plank"),
        ItemsViewModel_3(R.drawable.exe4, "Dumbbell rows"),
        ItemsViewModel_3(R.drawable.exe5, "Deadlift"),
        ItemsViewModel_3(R.drawable.exe6, "Glute Bridge"),
        ItemsViewModel_3(R.drawable.exe7, "Bent Over Row"),
        ItemsViewModel_3(R.drawable.exe8, "Running"),
        ItemsViewModel_3(R.drawable.exe1, "Squats"),
        ItemsViewModel_3(R.drawable.exe2, "Pushups"),
        ItemsViewModel_3(R.drawable.exe3, "Plank"),
        ItemsViewModel_3(R.drawable.exe4, "Dumbbell rows"),
        ItemsViewModel_3(R.drawable.exe5, "Deadlift"),
        ItemsViewModel_3(R.drawable.exe6, "Glute Bridge"),
        ItemsViewModel_3(R.drawable.exe7, "Bent Over Row"),
        ItemsViewModel_3(R.drawable.exe8, "Running")


    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beginner, container, false)

        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerView)

        // this creates a grid layout Manager with 2 columns
        recyclerview.layoutManager = GridLayoutManager(context, 2)

        // Setting the Adapter with the recyclerview
        val adapter = CustomAdapter_3(mNicolasCageMovies)
        recyclerview.adapter = adapter

        return view
    }
}
