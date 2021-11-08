package com.lucaskempe.android_challenge.service

import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.service.api.BoredAPI
import com.lucaskempe.android_challenge.service.response.BoredResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.util.*

class BoredService() {

    suspend fun getActivity(type: String, participants: String) : BoredResponse? {
        var body : BoredResponse? = null

            val callResponse = retrofitService.retrofit
                .create(BoredAPI::class.java)
                .getThingsToDo(type.lowercase(Locale.getDefault()), participants)
            val response: BoredResponse? = callResponse.body()

            if (callResponse.isSuccessful) {
                body = response
            }
        return body
    }

}

