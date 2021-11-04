package com.lucaskempe.android_challenge.Utils

sealed class Result<out T : Any> {

    class Success<out T : Any>(
        val results: T,
    ) : Result<T>()

    class Failure(val exception: Exception) : Result<Nothing>()

}