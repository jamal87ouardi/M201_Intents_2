package com.example.m201_intents_2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nuite = intent.getIntExtra("nuite", 0) // Default to 0 if not found
        val chambre = intent.getStringExtra("roomType") // Handle potential null
        val petitDejeuner = if (intent.getBooleanExtra("petit_dejouner", false)) "Oui" else "Non"
        val prix = intent.getIntExtra("prix", 0) // Default to 0 if not found
        val reteur = findViewById<Button>(R.id.btn2)

        val txt_info = findViewById<TextView>(R.id.info)
            txt_info.text = "Nuite: $nuite\nChambre: $chambre\nAvec P.D: $petitDejeuner"


        val txt_prix = findViewById<TextView>(R.id.prix)
        txt_prix.text = "Prix Total: ${prix}"


        reteur.setOnClickListener{
            finish()
        }
    }
}