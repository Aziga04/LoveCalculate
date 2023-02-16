package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.room.Prefs
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var prefs: Prefs

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment)




        if (prefs.isShown()){
            prefs.saveState()
            navController.navigate(R.id.BoardingFragment)
        }
    }
}