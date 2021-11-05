package com.lucaskempe.android_challenge.service

import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.service.api.BoredAPI
import com.lucaskempe.android_challenge.Utils.Result
import java.lang.Exception

class BoredService(private val api: RequestGenerator) {

    suspend fun getActivities(): Result<ActivityToDo> {

        val callResponse = api.createService(BoredAPI::class.java).getThingsToDo("hola")
        if (callResponse.isSuccessful) {
            //SAVE THE RESPONSE
        } else {
            return Result.Failure(Exception(callResponse.message()))
        }

        return Result.Failure(Exception(callResponse.message()))

    }

}