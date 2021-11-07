package com.lucaskempe.android_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucaskempe.android_challenge.view.ListTypeActivity
import android.widget.Toast
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.databinding.ActivityTermBinding
import com.lucaskempe.android_challenge.databinding.ActivityToDoBinding
import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.service.BoredService
import com.lucaskempe.android_challenge.service.api.BoredAPI
import com.lucaskempe.android_challenge.service.api.BoredAPI.Companion.BASE_URL
import com.lucaskempe.android_challenge.service.response.BoredResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class ToDoActivity () : AppCompatActivity() {

    private lateinit var binding: ActivityToDoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val amountOfParticipants = intent.getStringExtra("participants") ?: "0"
        val typeActivity = intent.getStringExtra("activityType")

        typeActivity?.let { getActivity(it, amountOfParticipants) }
        

    }

    private fun retrofitService() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun priceRangeToText(price : Double):String {
        return when{
            price == 0.0 -> R.string.priceFree.toString()
            price <= 0.3 -> R.string.priceLow.toString()
            price <= 0.6 -> R.string.priceMedium.toString()
            else -> R.string.priceHigh.toString()
        }
    }

    private fun getActivity(query: String, participants : String) {
        CoroutineScope(Dispatchers.IO).launch {

            val callResponse = retrofitService()
                .create(BoredAPI::class.java)
                .getThingsToDo(query.lowercase(Locale.getDefault()), participants)
            val response: BoredResponse? = callResponse.body()
            runOnUiThread {
                if (callResponse.isSuccessful) {
                    response.let {
                            binding.tvActivities.text = response?.activity
                            binding.tvParticipantsCount.text = response?.participants.toString()
                            binding.tvPriceDesc.text = priceRangeToText(response!!.price)
                            binding.tvType.text = response.type
                        }
                    }
                }
            }
        }

    }

