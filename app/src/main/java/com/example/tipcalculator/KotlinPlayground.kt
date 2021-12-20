package com.example.tipcalculator

import android.content.Intent
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

        try {
            makeRecyclerView(
                intent.getParcelableArrayListExtra<Tip>(TIP_OBJECT_LIST_KEY) as ArrayList<Tip>
            )
        }
        catch (e: Exception){
            log(e.toString())

            val myTips = ArrayList<Tip>()

            for (i in 1..5){
                myTips.add(
                    Tip("Test Tip $i",
                        ((10..50).random()).toDouble(),
                        5 * (2..4).random(),
                        true
                    )
                )
            }

            makeRecyclerView(myTips)
        }

    }

    private fun log(text: String = ""){
        Log.d(TAG, text)
    }

    private fun makeRecyclerView(tips: ArrayList<Tip>){
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = TipItemAdapter(this, tips)

        recyclerView.setHasFixedSize(true)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, 1)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

}