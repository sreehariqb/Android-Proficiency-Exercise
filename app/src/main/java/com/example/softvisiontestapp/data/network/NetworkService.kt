package com.example.softvisiontestapp.data.network

import com.example.softvisiontestapp.data.model.APIResponseData
import com.example.softvisiontestapp.data.network.NetworkConstants.END_POINT
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET(END_POINT)
    fun getApiData(): Call<APIResponseData>
}
