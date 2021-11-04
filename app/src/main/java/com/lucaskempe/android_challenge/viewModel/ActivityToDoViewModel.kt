package com.lucaskempe.android_challenge.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucaskempe.android_challenge.Utils.Result
import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.marvel_mvvm_clean.utils.Data
import com.lucaskempe.marvel_mvvm_clean.utils.Event
import com.lucaskempe.marvel_mvvm_clean.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivityToDoViewModel : ViewModel() {

    private var mutableMainState: MutableLiveData<Event<Data<List<ActivityToDo>>>> = MutableLiveData()
    val mainState: LiveData<Event<Data<List<ActivityToDo>>>>
    get() {
        return mutableMainState
    }

    fun onStart() = viewModelScope.launch {
        mutableMainState.value = Event(Data(Status.LOADING))
        when(val result = withContext(Dispatchers.IO) {} ) {
/*            is Result.Failure -> {
                mutableMainState.value = Event(Data(Status.ERROR, results = result.exception))
            }
            is Result.Success -> {
                mutableMainState.value = Event(Data(Status.SUCCESSFUL, result.results))
            }*/
        }
    }

}