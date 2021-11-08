package com.lucaskempe.android_challenge.service

import com.lucaskempe.android_challenge.service.api.BoredAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Retrofit Instance
object retrofitService {
    val retrofit: Retrofit
        get() {
        return Retrofit.Builder()
            .baseUrl(BoredAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}