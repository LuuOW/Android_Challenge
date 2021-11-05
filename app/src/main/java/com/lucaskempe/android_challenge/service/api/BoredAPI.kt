package com.lucaskempe.android_challenge.service.api

import com.lucaskempe.android_challenge.service.response.BoredResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredAPI {
  @GET("{activityName}")
  suspend fun getThingsToDo(@Query("activityName")activity:String) : Response<BoredResponse>
}