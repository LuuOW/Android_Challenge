package com.lucaskempe.android_challenge.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.service.BoredService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivityToDoViewModel(private val getActivity: BoredService, private val queryParameter: String) : ViewModel() {

   /* private val activityToDo: MutableLiveData<ActivityToDo> by lazy {
        MutableLiveData<ActivityToDo>().also {
            loadActivity()
        }
    }

    fun getActivityToDo(): LiveData<ActivityToDo> {
        return activityToDo
    }

    private fun loadActivity() {
        getActivity.getActivities(queryParameter)
    }*/

}