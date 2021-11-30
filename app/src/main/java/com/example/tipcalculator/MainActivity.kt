package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calculate(v: View){
        val percent = when(binding.tipSelectionRadioGroup.checkedRadioButtonId){
            R.id.selected_15_percent -> 0.15
            R.id.selected_20_percent -> 0.2
            else -> 0.1
        }
        var tip = binding.totalCostEditText.text.toString().toDouble() * percent
        if (binding.roundCostSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
        } else {
            tip = kotlin.math.floor(tip)
        }
        val formatedText = NumberFormat.getCurrencyInstance().format(tip)
        Toast.makeText(this, "Tip: $formatedText", Toast.LENGTH_SHORT).show()

    }
}