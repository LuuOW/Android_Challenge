package com.lucaskempe.android_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.databinding.ActivityTermBinding
import com.lucaskempe.android_challenge.databinding.ActivityToDoBinding
import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.service.BoredService
import com.lucaskempe.android_challenge.service.api.BoredAPI
import com.lucaskempe.android_challenge.service.response.BoredResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ToDoActivity () : AppCompatActivity() {

    private lateinit var binding: ActivityToDoBinding
    private var amountOfParticipants : String? = null
    private var typeActivity : String? = null
    private lateinit var thingToDO : BoredResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        amountOfParticipants = intent.getStringExtra("participants")
        typeActivity = intent.getStringExtra("activityType")

        typeActivity?.let { getActivity(it) }

        binding.tvPrice.text = thingToDO.price.toString()
        binding.tvParticipants.text = thingToDO.participants.toString()

    }

    private fun retrofitService() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/activity")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getActivity(query: String) {
        CoroutineScope(Dispatchers.IO).launch {

            val callResponse = retrofitService()
                .create(BoredAPI::class.java)
                .getThingsToDo("/$query")
            val response: BoredResponse? = callResponse.body()
            runOnUiThread {
                if (callResponse.isSuccessful) {
                    if (response != null) {
                        thingToDO = response
                    }
                }
            }
        }

    }

}