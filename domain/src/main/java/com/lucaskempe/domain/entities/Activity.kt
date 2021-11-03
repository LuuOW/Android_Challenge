package com.lucaskempe.domain.entities

import com.lucaskempe.domain.utils.EMPTY_FLOAT
import com.lucaskempe.domain.utils.EMPTY_NUMBER
import com.lucaskempe.domain.utils.EMPTY_STRING
import java.io.Serializable

class Activity(
    val type: String = EMPTY_STRING,
    val price: Double = EMPTY_FLOAT,
    val activity: String = EMPTY_STRING,
    val participants: Int = EMPTY_NUMBER
) : Serializable