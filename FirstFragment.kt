package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FirstFragment : Fragment() {

    private lateinit var editText: EditText
    private lateinit var buttonGo: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Initialize UI components
        editText = view.findViewById(R.id.edit_text)
        buttonGo = view.findViewById(R.id.button_go)

        // Set text from arguments if available
        val text = arguments?.getString("text")
        if (text != null) {
            editText.setText(text)
        }

        // Set click listener for the "Go" button
        buttonGo.setOnClickListener {
            val inputText = editText.text.toString()
            val secondFragment = SecondFragment()
            val args = Bundle()
            args.putString("text", inputText)
            secondFragment.arguments = args

            // Replace FirstFragment with SecondFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, secondFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}