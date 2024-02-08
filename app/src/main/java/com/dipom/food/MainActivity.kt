package com.dipom.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.dipom.food.databinding.ActivityMainBinding
import com.dipom.food.mvp.ui.MealsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, MealsFragment.newInstance())
            .commit()

    }
}