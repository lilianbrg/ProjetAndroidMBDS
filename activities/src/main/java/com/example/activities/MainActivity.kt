package com.example.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton1 = findViewById(R.id.btn_click_me1)
        textButton = findViewById(R.id.text_on_click)
        clickButton2 = findViewById(R.id.btn_click_me2)
        computeButton = findViewById(R.id.btn_compute)

        clickButton1.setOnClickListener {
            nbClick++

            if (nbClick <= 5){
                val newText = "Cliquez moi $nbClick"
                textButton.text = newText
            }
            if (nbClick > 5) {
                clickButton1.setEnabled(false);
                val newText = "Vous avez appuyé plus de 5 fois."
                textButton.text = newText
            }
        }

        clickButton2.setOnClickListener{
            nbClick = 0
            textButton.text = "Réinitialisé"
            clickButton1.setEnabled(true);
        }

        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }

    private lateinit var textButton: TextView
    private lateinit var clickButton1: Button
    private lateinit var clickButton2: Button
    private lateinit var computeButton: Button

    private var nbClick = 0
}