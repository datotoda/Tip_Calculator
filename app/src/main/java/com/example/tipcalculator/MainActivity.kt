package com.example.tipcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.example.tipcalculator.model.Tip
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val myTips = ArrayList<Tip>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calculate(v: View){
        val totalCostString = binding.totalCostEditText.text.toString()

        val percent = when(binding.tipSelectionRadioGroup.checkedRadioButtonId){
            R.id.selected_15_percent -> 15
            R.id.selected_20_percent -> 20
            else -> 10
        }

        val newTip = Tip("Tip: $totalCostString",
            totalCostString.toDouble(),
            percent,
            binding.roundCostSwitch.isChecked)

        val formattedText = NumberFormat.getCurrencyInstance().format(newTip.calculateTip())

        Toast.makeText(this, "Tip: $formattedText", Toast.LENGTH_SHORT).show()


        myTips.add(newTip)
    }

    fun onOpenMyTips(v: View){
        val playgroundBundle = Bundle()
        val myTipsMod = ArrayList<Tip>()

        myTips.forEach { tip ->
            myTipsMod.add(tip)
        }

        val tip0 = Tip("Tip 0 title", (100).toDouble(), 15, false)
        val tip1 = Tip("Tip 1 title", (147).toDouble(), 10, true)
        val tip2 = Tip("Tip 2 title", (34).toDouble(), 20, true)
        myTipsMod.add(tip0)
        myTipsMod.add(tip1)
        myTipsMod.add(tip2)

        for (i in 3..15){
            myTipsMod.add(
                Tip("Tip $i title",
                    ((10..50).random()).toDouble(),
                    5 * (2..4).random(),
                    true))
        }

        playgroundBundle.putParcelableArrayList(TIP_OBJECT_LIST_KEY, myTipsMod)

        val playgroundIntent = Intent(this, KotlinPlayground::class.java)

        playgroundIntent.putExtras(playgroundBundle)

        startActivity(playgroundIntent)
    }

}