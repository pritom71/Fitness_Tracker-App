package com.stamasoft.ptithom.kotlin_demoapp_navdrawer_v1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Get the data from the Intent
        val exerciseTitle = intent.getStringExtra("EXERCISE_TITLE")
        val exerciseTime = intent.getStringExtra("EXERCISE_TIME")
        val exerciseType = intent.getStringExtra("EXERCISE_TYPE")
        val exerciseImageId = intent.getIntExtra("EXERCISE_IMAGE_ID", 0)

        // Set the data to the views
        val titleTextView = findViewById<TextView>(R.id.exerciseTitle)
        val timeTextView = findViewById<TextView>(R.id.exerciseTime)
        val typeTextView = findViewById<TextView>(R.id.exerciseType)
        val imageView = findViewById<ImageView>(R.id.exerciseImage)

        titleTextView.text = exerciseTitle
        timeTextView.text = exerciseTime
        typeTextView.text = exerciseType
        imageView.setImageResource(exerciseImageId)
    }
}
