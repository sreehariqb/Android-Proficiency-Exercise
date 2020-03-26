package com.example.softvisiontestapp.data.network

import com.example.softvisiontestapp.data.model.ApiResponseData
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET("/s/2iodh4vg0eortkl/facts.json")
    fun getApiData(): Call<ApiResponseData>
}
