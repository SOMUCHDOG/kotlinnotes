package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class SecondFragment : Fragment() {

    private lateinit var editText: EditText
    private lateinit var buttonBack: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        // Initialize UI components
        editText = view.findViewById(R.id.edit_text)
        buttonBack = view.findViewById(R.id.button_back)

        // Set text from arguments if available
        val text = arguments?.getString("text")
        if (text != null) {
            editText.setText(text)
        }

        // Set click listener for the "Back" button
        buttonBack.setOnClickListener {
            val inputText = editText.text.toString()
            val firstFragment = FirstFragment()
            val args = Bundle()
            args.putString("text", inputText)
            firstFragment.arguments = args

            // Replace SecondFragment with FirstFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, firstFragment)
                .commit()
        }

        return view
    }
}