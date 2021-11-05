package com.lucaskempe.android_challenge.view

import CustomAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager

import com.lucaskempe.android_challenge.data.ActivityList
import com.lucaskempe.android_challenge.databinding.ActivityListTypeBinding



class ListTypeActivity : AppCompatActivity(), CustomAdapter.CustomListener {


    private val listTypeActivity = ActivityList.values()
    private val adapter = CustomAdapter(listTypeActivity, this)
    private lateinit var binding: ActivityListTypeBinding
    private var amountOfParticipants : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerViewListType.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewListType.adapter = adapter

        amountOfParticipants = intent.getStringExtra("participants")


    }

    override fun onClickActivity(query : String) {
        Toast.makeText(this, "$query - $amountOfParticipants", Toast.LENGTH_SHORT).show()
       val intent = Intent(this, ToDoActivity::class.java).apply {
            putExtra("participants", amountOfParticipants)
            putExtra("activityType", query)
        }
        startActivity(intent)
    }
}