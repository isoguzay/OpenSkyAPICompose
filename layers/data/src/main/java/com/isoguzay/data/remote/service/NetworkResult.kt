package com.isoguzay.data.remote.service

sealed class NetworkResult<out T> {
    data class Progress<T>(var isLoading: Boolean) : NetworkResult<T>()
    data class Success<T>(var data: T?) : NetworkResult<T>()
    data class Failure<T>(val statusCode: Int = -1, val exception: Throwable? = null) : NetworkResult<T>()
}