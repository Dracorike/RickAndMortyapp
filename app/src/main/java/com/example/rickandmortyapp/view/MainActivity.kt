package com.example.rickandmortyapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.scopes.ActivityScoped

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVariables()
        initFragmentOnActivity()
    }

    private fun initVariables() {
        navController = findNavController(R.id.fragment_container_main)
    }

    private fun initFragmentOnActivity() {
        navController.navigate(R.id.listOfCharactersFragment)
    }
}