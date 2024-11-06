package com.stamasoft.ptithom.kotlin_demoapp_navdrawer_v1

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter(
    private val context: Activity,
    private val title: Array<String>,
    private val time: Array<String>,
    private val description: Array<String>,
    private val imgid: Array<Int>
) : ArrayAdapter<String>(context, R.layout.custom_all_listview, description) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_all_listview, null, true)

        val titleText = rowView.findViewById<TextView>(R.id.card_title)
        val imageView = rowView.findViewById<ImageView>(R.id.card_image)
        val subtitleText = rowView.findViewById<TextView>(R.id.card_subtitle)
        val timeText = rowView.findViewById<TextView>(R.id.card_description)

        titleText.text = title[position]
        imageView.setImageResource(imgid[position])
        subtitleText.text = description[position]
        timeText.text = time[position]

        return rowView
    }
}
