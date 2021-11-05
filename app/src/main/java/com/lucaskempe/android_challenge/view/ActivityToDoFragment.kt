package com.lucaskempe.android_challenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.entities.ActivityToDo


class ActivityToDoFragment : DialogFragment() {

    lateinit var activityToDo: ActivityToDo


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activity_to_do, null)
    }

    override fun onViewCreated(view: View, activityInstanceState: Bundle?) {
        super.onViewCreated(view, activityInstanceState)

        //HERE GOES FRAGMENT BINDING....


    }


    companion object {
        @JvmStatic
        fun activityInstance(): ActivityToDoFragment {
            val frag = ActivityToDoFragment()
            val args = Bundle()
            frag.arguments = args
            return frag

        }
        const val TAG = "ActivityDialog"
    }

}