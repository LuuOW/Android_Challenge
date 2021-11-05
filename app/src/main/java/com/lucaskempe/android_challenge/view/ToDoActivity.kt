package com.lucaskempe.android_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.databinding.ActivityTermBinding
import com.lucaskempe.android_challenge.databinding.ActivityToDoBinding
import com.lucaskempe.android_challenge.service.BoredService
import com.lucaskempe.android_challenge.service.api.BoredAPI

class ToDoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToDoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun getActivity(service: BoredService) {

    }


}