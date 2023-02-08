package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.lovecalculator.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  pref = Prefs(this)

        pref.saveState()
        if (pref.isShown()){
            navController.navigate(R.id.BoardingFragment)
        }
    }
}