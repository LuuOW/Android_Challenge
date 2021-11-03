package com.lucaskempe.android_challenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.databinding.ActivityMainBinding
import com.lucaskempe.android_challenge.entities.ActivityToDo

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, ListTypeActivity::class.java).apply {
                putExtra("participants", binding.etParticipant.text.toString())
            }
            startActivity(intent)
        }

        binding.tvTerms.setOnClickListener{
            val intent = Intent(this, TermActivity::class.java).apply {
                putExtra("participants", binding.etParticipant.text.toString())
            }
            startActivity(intent)
        }
        
    }


}