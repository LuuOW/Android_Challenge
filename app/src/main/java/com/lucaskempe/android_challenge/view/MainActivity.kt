package com.lucaskempe.android_challenge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.databinding.ActivityMainBinding
import com.lucaskempe.android_challenge.entities.ActivityToDo

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

            binding.btnStart.setOnClickListener {
                if (validateImput()) {

                    val intent = Intent(this, ListTypeActivity::class.java).apply {
                        putExtra("participants", binding.etParticipant.text.toString())
                    }
                    startActivity(intent)   
                } else {
                    binding.etParticipant.requestFocus()
                    Toast.makeText(this, R.string.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }


            binding.tvTerms.setOnClickListener {  //show the terms and conditions
                val intent = Intent(this, TermActivity::class.java)
                startActivity(intent)
            }

            binding.etParticipant.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    binding.btnStart.isEnabled = validateImput()

                }
            }
        }
    fun validateImput(): Boolean{
        return !binding.etParticipant.text.toString().isNullOrEmpty() &&
                Integer.parseInt(binding.etParticipant.text.toString()) >= 1
    }
}


