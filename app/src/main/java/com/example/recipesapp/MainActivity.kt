package com.example.recipesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.recipesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSystemBars()
    }

    private fun setupSystemBars() {
        val bgColor = ContextCompat.getColor(this, R.color.color_main_background)
        window.statusBarColor = bgColor
        window.navigationBarColor = bgColor
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}