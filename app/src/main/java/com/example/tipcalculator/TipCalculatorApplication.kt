package com.example.tipcalculator

import android.app.Application
import com.example.tipcalculator.database.AppDatabase

class TipCalculatorApplication: Application() {
    val database:AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}