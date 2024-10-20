package com.quispe.angelo.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import androidx.cardview.widget.CardView

class Ejercicio01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio01)

        // Setup for insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find views
        val cardView = findViewById<CardView>(R.id.cardView)
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)
        val btnOcultar = findViewById<Button>(R.id.btnOcultar)

        // Set click listeners
        btnMostrar.setOnClickListener {
            cardView.visibility = View.VISIBLE  // Show the CardView
        }

        btnOcultar.setOnClickListener {
            cardView.visibility = View.GONE  // Hide the CardView
        }
    }
}
