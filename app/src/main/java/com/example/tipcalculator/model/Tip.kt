package com.example.tipcalculator.model

class Tip (val title: String,
           val price: Double,
           val tipAmount: Int,
           val isrRounded: Boolean){

    fun calculateTip(): Double {
        val total = (price * tipAmount) / 100
        return when (isrRounded){
            true -> kotlin.math.ceil(total)
            false -> kotlin.math.floor(total)
        }
    }
}
