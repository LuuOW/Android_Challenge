package com.lucaskempe.android_challenge.service.api

import com.lucaskempe.android_challenge.service.response.BoredResponse
import retrofit2.Response
import retrofit2.http.GET

interface BoredAPI {

  @GET
  suspend fun getThingsToDo(thingsToDo : String) : Response<BoredResponse>
}