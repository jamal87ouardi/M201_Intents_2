package com.example.m201_intents_2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nuite_inpt = findViewById<EditText>(R.id.Nuite)
        val simple = findViewById<RadioButton>(R.id.simple)
        val double = findViewById<RadioButton>(R.id.cdouble)
        val multiple = findViewById<RadioButton>(R.id.multiple)
        val petit_dejouner = findViewById<Switch>(R.id.avecPD)
        val button = findViewById<Button>(R.id.send)

        button.setOnClickListener {
            val Nuite = nuite_inpt.text.toString().toIntOrNull()
            val p_d = petit_dejouner.text.toString()
            var prix = 0
            var Type_de_chambre: String? = null

            // nuite et un nombre (int)
            if (Nuite != null) {
                if (simple.isChecked) {
                    prix = Nuite * 250
                    Type_de_chambre = "Simple"
                } else if (double.isChecked) {
                    prix = Nuite * 350
                    Type_de_chambre = "Double"
                } else if (multiple.isChecked) {
                    prix = Nuite * 500
                    Type_de_chambre = "Multiple"
                }

                // ajouter le prix de P.D
                if (petit_dejouner.isChecked) {
                    prix += when {
                        simple.isChecked -> Nuite * 40
                        double.isChecked -> Nuite * 80
                        multiple.isChecked -> Nuite * 120
                        else -> 0
                    }
                }

                val i = Intent(this, Second::class.java)
                    i.putExtra("nuite", Nuite)
                    i.putExtra("prix", prix)
                    i.putExtra("roomType", Type_de_chambre)
                    i.putExtra("petit_dejouner", p_d)

                    startActivity(i)
            }
        }

    }
}