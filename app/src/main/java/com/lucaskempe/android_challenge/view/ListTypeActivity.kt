package com.lucaskempe.android_challenge.view

import CustomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.data.ActivityList
import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.viewModel.ActivityToDoViewModel

class ListTypeActivity : AppCompatActivity() {

    private val listTypeActivity = ActivityList.values()

    private val adapter = CustomAdapter(listOf<>(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_type)




    }



}