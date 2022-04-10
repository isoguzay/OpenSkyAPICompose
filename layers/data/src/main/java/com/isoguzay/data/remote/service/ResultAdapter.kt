package com.isoguzay.data.remote.service

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class ResultAdapter(private val type: Type) : CallAdapter<Type, Call<NetworkResult<Type>>> {
    override fun responseType() = type
    override fun adapt(call: Call<Type>): Call<NetworkResult<Type>> = ResultCall(call)
}
