package com.lucaskempe.android_challenge.view

import CustomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.data.ActivityList
import com.lucaskempe.android_challenge.databinding.ActivityListTypeBinding

class ListTypeActivity : AppCompatActivity() {

    private val listTypeActivity = ActivityList.values()
    private val adapter = CustomAdapter(listTypeActivity)
    private lateinit var binding: ActivityListTypeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewListType)
        recyclerView.adapter

    }



}