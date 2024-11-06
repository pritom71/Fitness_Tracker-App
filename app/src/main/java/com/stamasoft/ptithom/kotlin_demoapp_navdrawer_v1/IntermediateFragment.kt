package com.stamasoft.ptithom.kotlin_demoapp_navdrawer_v1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import java.text.MessageFormat
import java.util.Locale

class IntermediateFragment : Fragment() {

    private lateinit var textView: TextView
    private lateinit var reset: MaterialButton
    private lateinit var start: MaterialButton
    private lateinit var stop: MaterialButton
    private var seconds: Int = 0
    private var minutes: Int = 0
    private var milliSeconds: Int = 0
    private var millisecondTime: Long = 0L
    private var startTime: Long = 0L
    private var timeBuff: Long = 0L
    private var updateTime: Long = 0L
    private lateinit var handler: Handler

    private val runnable = object : Runnable {
        override fun run() {
            millisecondTime = SystemClock.uptimeMillis() - startTime
            updateTime = timeBuff + millisecondTime
            seconds = (updateTime / 1000).toInt()
            minutes = seconds / 60
            seconds = seconds % 60
            milliSeconds = (updateTime % 1000).toInt()

            textView.text = MessageFormat.format(
                "{0}:{1}:{2}",
                minutes,
                String.format(Locale.getDefault(), "%02d", seconds),
                String.format(Locale.getDefault(), "%01d", milliSeconds)
            )
            handler.postDelayed(this, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_intermediate, container, false)

        textView = view.findViewById(R.id.textView)
        reset = view.findViewById(R.id.reset)
        start = view.findViewById(R.id.start)
        stop = view.findViewById(R.id.stop)

        handler = Handler(Looper.getMainLooper())

        start.setOnClickListener {
            startTime = SystemClock.uptimeMillis()
            handler.postDelayed(runnable, 0)
            reset.isEnabled = false
            stop.isEnabled = true
            start.isEnabled = false
        }

        stop.setOnClickListener {
            timeBuff += millisecondTime
            handler.removeCallbacks(runnable)
            reset.isEnabled = true
            stop.isEnabled = false
            start.isEnabled = true
        }

        reset.setOnClickListener {
            millisecondTime = 0L
            startTime = 0L
            timeBuff = 0L
            updateTime = 0L
            seconds = 0
            minutes = 0
            milliSeconds = 0
            textView.text = "00:00:00"
        }

        textView.text = "00:00:00"

        return view
    }
}
