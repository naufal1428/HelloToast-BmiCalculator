package com.example.hellotoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hellotoast.databinding.ActivityBmiBinding
import com.example.hellotoast.databinding.ActivityMainBinding
import kotlin.math.pow

class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener {
            calculateBmi()
        }

        binding.btnToast.setOnClickListener {
            toastBmi()
        }
    }

    private fun calculateBmi() {
        val berat = binding.beratEditText.text.toString().toFloatOrNull()
        val tinggi = binding.tinggiEditText.text.toString().toFloatOrNull()

        if (berat != null && tinggi!= null) {
            val bmi = berat / (tinggi/100).pow(2)
            val bmiResult = String.format("%.2f", bmi)
            binding.resultTextView.text = "$bmiResult"
        }
    }

    private fun toastBmi() {
        val berat = binding.beratEditText.text.toString().toFloatOrNull()
        val tinggi = binding.tinggiEditText.text.toString().toFloatOrNull()

        if (berat != null && tinggi!= null) {
            val bmi = berat / (tinggi/100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal Weight"
                bmi < 30 -> "Overweight"
                else -> "Obesity"
            }

            Toast.makeText(this@BmiActivity, "$bmiCategory", Toast.LENGTH_SHORT).show()
        }
    }
}