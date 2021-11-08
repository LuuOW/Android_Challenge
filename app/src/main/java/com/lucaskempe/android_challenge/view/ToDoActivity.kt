package com.lucaskempe.android_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.UtilsFunc
import com.lucaskempe.android_challenge.databinding.ActivityToDoBinding
import com.lucaskempe.android_challenge.service.BoredService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*


class ToDoActivity () : AppCompatActivity() {
    /******************* ToDoActivity **********************
     * This activity is responsible for making the API call and
     * displaying the response on the screen
     ********************************************************/

    private lateinit var binding: ActivityToDoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //We receive the parameters from the previous activity and we send it to the function that makes the call to the service
        val amountOfParticipants = intent.getStringExtra("participants") ?: "0"
        val typeActivity = intent.getStringExtra("activityType") ?: ""

        //call to service
        getActivity(typeActivity,amountOfParticipants)


        binding.btnAnother.setOnClickListener {
            getActivity(typeActivity,amountOfParticipants)
        }

    }
    private fun getActivity(typeActivity: String, amountOfParticipants : String) {
            //we hide all the components and only show a progressbar
            showOrHideComponents(false)

            CoroutineScope(Dispatchers.IO).launch {
                val response = BoredService().getActivity(typeActivity, amountOfParticipants)
                runOnUiThread {
                    response.let {
                        showOrHideComponents(true)
                        //we load the response data into the components
                        //TODO: Check execptions if there is an error or if the parameters sent do not return an activity
                        binding.tvActivities.text = response?.activity
                        binding.tvParticipantsCount.text = response?.participants.toString()
                        binding.tvPriceDesc.text = UtilsFunc().priceRangeToText(response!!.price)
                        binding.tvType.text = response.type
                    }
                }
            }
    }
    //function that hides or shows the UI components according to a flag
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

