package com.isoguzay.data.remote.service

import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultCall<T>(proxy: Call<T>) : CallDelegate<T, NetworkResult<T>>(proxy) {
    override fun enqueueImpl(callback: Callback<NetworkResult<T>>) = proxy.enqueue(object :
        Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            val result = if (response.isSuccessful)
                NetworkResult.Success(response.body())
            else
                NetworkResult.Failure(response.code())

            callback.onResponse(this@ResultCall, Response.success(result))
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            val result = NetworkResult.Failure<T>(exception = t)
            callback.onResponse(this@ResultCall, Response.success(result))
        }
    })

    override fun cloneImpl() = ResultCall(proxy.clone())

    override fun timeout() = Timeout()
}