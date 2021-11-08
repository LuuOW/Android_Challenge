package com.lucaskempe.android_challenge

const val EMPTY_STRING: String = ""
const val EMPTY_INT: Int = 0

//I change the price for a text according to its range ... PS: I did not know where to put this function
class UtilsFunc(){
    fun priceRangeToText(price : Double):String {
        return when{
            price == 0.0 -> "Free"
            price <= 0.3 -> "Low"
            price <= 0.6 -> "Medium"
            else -> "High"
        }
    }

}