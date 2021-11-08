package com.lucaskempe.android_challenge.service.api

import com.lucaskempe.android_challenge.service.response.BoredResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredAPI {
  companion object {
    const val BASE_URL = "https://www.boredapi.com/"
  }
  @GET("api/activity/")
  suspend fun getThingsToDo(@Query("type")activity: String,
                            @Query("participants") participants: String) : Response<BoredResponse>

  //TODO:Implement the random search button using this function
  suspend fun getRandomThingToDo() : Response<BoredResponse>
}