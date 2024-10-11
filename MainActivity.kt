package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout file for the activity
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Load FirstFragment at the start
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FirstFragment())
                .commit()
        }
    }
}