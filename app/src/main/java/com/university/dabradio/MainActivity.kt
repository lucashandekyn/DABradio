package com.university.dabradio

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {

    private val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    private var spinnerList = ArrayList<Spinner>()
    private val settings = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Loop to configure the existing Spinners
        for (i in 1..6) {
            // Get the Spinner by its ID
            val spinnerId = resources.getIdentifier("spinner$i", "id", packageName)
            val spinner = findViewById<Spinner>(spinnerId)

            // Create an ArrayAdapter to provide text labels for the Spinner items
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

            // Set the dropdown layout resource for the ArrayAdapter
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Set the ArrayAdapter as the adapter for the Spinner
            spinner.adapter = adapter

            // Set up a callback for item selection on the Spinner
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    // Get the selected item and store it in your data model or variable
                    val selectedItem = parent?.getItemAtPosition(position).toString()
                    // Update your data model or variable with the selected item
                    settings.add(selectedItem)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Do nothing
                }
            }
            spinnerList.add(spinner)
        }

    }
}
