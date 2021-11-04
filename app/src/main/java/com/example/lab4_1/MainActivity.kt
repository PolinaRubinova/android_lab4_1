package com.example.lab4_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab4_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button.setOnClickListener { onClick() }
        if (!clicked) {binding.button.setBackgroundColor(Color.GREEN)}
        setContentView(binding.root)
    }

    private fun onClick() {
        if (!clicked) {
            binding.button.text = getString(R.string.cl_button)
            clicked = true
            binding.button.setBackgroundColor(Color.RED)
        }
    }
}