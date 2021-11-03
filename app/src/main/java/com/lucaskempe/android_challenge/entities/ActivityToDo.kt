package com.lucaskempe.android_challenge.entities

import com.lucaskempe.android_challenge.EMPTY_INT
import com.lucaskempe.android_challenge.EMPTY_STRING

class ActivityToDo (
    val activity: String = EMPTY_STRING ,
    val participants: Int = EMPTY_INT,
    val price: Double = 0.0,
    val type: String = EMPTY_STRING
)