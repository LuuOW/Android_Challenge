package com.lucaskempe.android_challenge.view

import CustomAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.data.ActivityList
import com.lucaskempe.android_challenge.databinding.ActivityListTypeBinding
import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.service.BoredService
import com.lucaskempe.android_challenge.viewModel.ActivityToDoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


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

    override fun onClickActivity() {
        val intent = Intent(this, ToDoActivity::class.java)
        startActivity(intent)
    }
}