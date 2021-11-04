package com.lucaskempe.marvel_mvvm_clean.utils

data class Data<RequestData>(var responseType: Status, var results: RequestData? = null, var error: Exception? = null)

enum class Status { SUCCESSFUL, ERROR, LOADING }
