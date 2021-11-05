package com.lucaskempe.android_challenge.service

import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.service.api.BoredAPI
import com.lucaskempe.android_challenge.service.response.BoredResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class BoredService(private val api: RequestGenerator) {


    fun getActivities(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val callResponse = api.createService(BoredAPI::class.java).getThingsToDo(query)
            val response: BoredResponse? = callResponse.body()

            if (callResponse.isSuccessful) {
                val data : BoredResponse? = response
            }
        }
    }

}