package com.example.softvisiontestapp.data.network

import androidx.lifecycle.MutableLiveData
import com.example.softvisiontestapp.data.model.APIResponse
import com.example.softvisiontestapp.data.model.APIResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Handles network operations
 */
object NetworkDataSource {
    private val apiResponseData: MutableLiveData<APIResponse> = MutableLiveData()
    fun getAPIResponseData(): MutableLiveData<APIResponse> {
        getAPIUpdates()
        return apiResponseData
    }

    private fun getAPIUpdates() {
        val service: NetworkService = RetrofitClientInstance.retrofitInstance.create(
            NetworkService::class.java
        )
        val call: Call<APIResponseData> = service.getApiData()
        call.enqueue(object : Callback<APIResponseData> {
            override fun onFailure(call: Call<APIResponseData>, t: Throwable) {
                apiResponseData.postValue(APIResponse(null, t))
            }

            override fun onResponse(
                call: Call<APIResponseData>,
                response: Response<APIResponseData>
            ) {
                apiResponseData.postValue(APIResponse(response.body()))
            }

        })
    }
}
