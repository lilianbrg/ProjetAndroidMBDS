package com.example.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class ComputeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)

        buttonCalculate = findViewById(R.id.btn_calculer)
        editTextNumber1 = findViewById(R.id.field_1)
        editTextNumber2 = findViewById(R.id.field_2)
        txtCalculate = findViewById(R.id.resultat)

        if (editTextNumber1.text.toString().length <= 0 && editTextNumber2.text.toString().length <= 0){
            buttonCalculate.setEnabled(false);
        }

        editTextNumber1.doAfterTextChanged {

            if (editTextNumber1.text.toString().length <= 0 || editTextNumber2.text.toString().length <= 0){
                buttonCalculate.setEnabled(false);
            }
            else{
                buttonCalculate.setEnabled(true);
            }
        }

        editTextNumber2.doAfterTextChanged {
            if (editTextNumber1.text.toString().length <= 0 || editTextNumber2.text.toString().length <= 0){
                buttonCalculate.setEnabled(false);
            }
            else{
                buttonCalculate.setEnabled(true);
            }
        }

        buttonCalculate.setOnClickListener{
            val calcul = editTextNumber1.text.toString().toDouble() + editTextNumber2.text.toString().toDouble()
            txtCalculate.text = calcul.toString()
        }

    }

    private lateinit var buttonCalculate: Button
    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var txtCalculate: TextView
}

