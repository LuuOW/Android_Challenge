package com.lucaskempe.android_challenge.view

import androidx.recyclerview.widget.RecyclerView
import com.lucaskempe.android_challenge.entities.ActivityToDo

class CustomAdapter (
    private var activities: List<ActivityToDo> = mutableListOf(),
    var listener = CustomListener
        ) :

        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        }