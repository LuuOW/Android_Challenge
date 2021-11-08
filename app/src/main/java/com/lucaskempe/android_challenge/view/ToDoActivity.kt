package com.lucaskempe.android_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.lucaskempe.android_challenge.UtilsFunc
import com.lucaskempe.android_challenge.databinding.ActivityToDoBinding
import com.lucaskempe.android_challenge.service.BoredService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class ToDoActivity () : AppCompatActivity() {

    private lateinit var binding: ActivityToDoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val amountOfParticipants = intent.getStringExtra("participants") ?: "0"
        val typeActivity = intent.getStringExtra("activityType") ?: ""

        getActivity(typeActivity,amountOfParticipants)

        binding.btnAnother.setOnClickListener {
            getActivity(typeActivity,amountOfParticipants)
        }

    }
    private fun getActivity(typeActivity: String, amountOfParticipants : String) {
        showOrHideComponents(false)
        CoroutineScope(Dispatchers.IO).launch {
            val response = BoredService().getActivity(typeActivity, amountOfParticipants)
            runOnUiThread {
                response.let {
                    showOrHideComponents(true)
                    binding.tvActivities.text = response?.activity
                    binding.tvParticipantsCount.text = response?.participants.toString()
                    binding.tvPriceDesc.text = UtilsFunc().priceRangeToText(response!!.price)
                    binding.tvType.text = response.type
                }
            }
        }
    }

    private fun showOrHideComponents(flag: Boolean) {
        with(binding) {
            tvActivities.isVisible = flag
            tvPrice.isVisible = flag
            tvPriceDesc.isVisible = flag
            tvType.isVisible = flag
            tvParticipantsCount.isVisible = flag
            tvParticipants.isVisible = flag
            btnAnother.isEnabled = flag
            progressBar.isVisible = !flag
        }
    }

}

