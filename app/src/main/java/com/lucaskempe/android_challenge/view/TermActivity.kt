package com.lucaskempe.android_challenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucaskempe.android_challenge.databinding.ActivityMainBinding

class TermActivity : AppCompatActivity() {

    private lateinit var binding = TermActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}