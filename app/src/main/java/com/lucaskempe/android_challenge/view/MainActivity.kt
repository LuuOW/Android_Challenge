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
    /******************* MainActivity **************************
     * Activity in charge of showing the main screen that contains
     * an editText and a button to specify the number of participants,
     * and a TexView that takes us to the terms and conditions
     **************************************************************/

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

            //It is evaluated that a number less than 1 or empty has not been entered, in which case the user is notified
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

            //the activity is changed when clicking on the text of terms and conditions
            binding.tvTerms.setOnClickListener {
                val intent = Intent(this, TermActivity::class.java)
                startActivity(intent)
            }

            //if the focus of the editText of participants is lost, the button is deactivated if it has invalid values
            binding.etParticipant.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    binding.btnStart.isEnabled = validateImput()

                }
            }
        }

    //function that returns true or false in case the value of participants is less than 1 or is empty
    fun validateImput(): Boolean{
        return !binding.etParticipant.text.toString().isNullOrEmpty() &&
                Integer.parseInt(binding.etParticipant.text.toString()) >= 1
    }
}


