package com.lucaskempe.android_challenge.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.entities.ActivityToDo

class CustomAdapter (
    private var activities: List<ActivityToDo> = mutableListOf(),
    var listener: CustomListener
) :

    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface CustomListener {
        fun onClickedActivity(activity: ActivityToDo)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var activityDetails: ActivityToDo

        init {
            itemView.setOnClickListener {
                listener.onClickedActivity()
            }
        }

        fun binding(activityToDo: ActivityToDo) {
            activityDetails = activityToDo


        }

    }

    fun setActivity(activity: List<ActivityToDo>) {
        this.activities = activities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(activities[position])
    }

    override fun getItemCount() = activities.size


}