package com.example.sesameassignment.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sesameassignment.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateMain()
    }
    private fun navigateMain() {
        val nextScreenIntent = Intent(this, Home::class.java)
        startActivity(nextScreenIntent)
    }
}