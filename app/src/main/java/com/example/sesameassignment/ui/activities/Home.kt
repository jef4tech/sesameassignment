package com.example.sesameassignment.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sesameassignment.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            val nextScreenIntent = Intent(this, ListActivity::class.java)
            startActivity(nextScreenIntent)
        }
        binding.button2.setOnClickListener{
            val nextScreenIntent = Intent(this, CustomerAdd::class.java)
            startActivity(nextScreenIntent)
        }
    }
}