package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TimeFormatException
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.tipcalculator.adapter.TipItemAdapter
import com.example.tipcalculator.model.Tip
import androidx.recyclerview.widget.DividerItemDecoration
import java.util.*
import kotlin.collections.ArrayList


const val TIP_OBJECT_LIST_KEY = "com.example.tipcalculator.TIP_OBJECT_LIST_KEY"


private const val TAG = "runKotlinCode"

class KotlinPlayground : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_playground)

//        runKotlinCode()


        val myTips = intent.getParcelableArrayListExtra<Tip>(TIP_OBJECT_LIST_KEY) as ArrayList<Tip>


        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = TipItemAdapter(this, myTips)

        recyclerView.setHasFixedSize(true)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, 1)
        recyclerView.addItemDecoration(dividerItemDecoration)

    }

    private fun log(text: String = ""){
        Log.d(TAG, text)
    }

    private fun runKotlinCode(){
        log("START")
//        val numbers: MutableList<Int> = mutableListOf(2, 4, 6, 8, 10)
//        val devices: MutableList<String> = mutableListOf("Alexa", "Home Kit", "IPhone", "S 21")
//
//        numbers.add(12)
//        numbers.add(14)
//        numbers.add(16)
//
//        devices[2] = "Macbook PRO"
//        devices.removeAt(3)
//
//        log( "List $devices")
//        log( "List $numbers")
//        log( "Size ${numbers.size}")
//
//        log( "First element ${numbers.first()}")
//        log( "First element ${numbers[0]}")
//
//        log( "Last element ${numbers.last()}")
//        log( "Last element ${numbers[numbers.size - 1]}")
//
//        for (device in devices){
//            log(device)
//        }

//        val myTips = mutableListOf<Tip>()
//
//        val tip0 = Tip("Tip 0 title", (100).toDouble(), 15, false)
//        val tip1 = Tip("Tip 1 title", (147).toDouble(), 10, true)
//        val tip2 = Tip("Tip 2 title", (34).toDouble(), 20, true)
//
//        log("Tip 0 ${tip0.calculateTip()}")
//        log("Tip 1 ${tip1.calculateTip()}")
//        log("Tip 2 ${tip2.calculateTip()}")
//
//        myTips.add(tip0)
//        myTips.add(tip1)
//        myTips.add(tip2)
//
//        myTips.forEach { tip ->
//            log("${tip.title} ${tip.calculateTip()}")
//        }
//
//
//        log("Size ${myTips}")



        log("END")
    }

}