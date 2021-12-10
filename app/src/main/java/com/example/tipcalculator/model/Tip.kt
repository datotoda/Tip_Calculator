package com.example.tipcalculator.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Tip (val title: String,
           val price: Double,
           val tipAmount: Int,
           val isrRounded: Boolean): Parcelable{

    fun calculateTip(): Double {
        val total = (price * tipAmount) / 100
        return when (isrRounded){
            true -> kotlin.math.ceil(total)
            false -> kotlin.math.floor(total)
        }
    }
}
