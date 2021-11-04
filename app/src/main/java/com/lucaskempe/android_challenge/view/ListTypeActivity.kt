package com.lucaskempe.android_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.viewModel.ActivityToDoViewModel

class ListTypeActivity : AppCompatActivity(), CustomAdapter.CustomListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_type)
    }

    override fun onClickedActivity(activity: ActivityToDo) {
        TODO("Not yet implemented")
    }



}