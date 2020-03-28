package com.example.softvisiontestapp.data.network

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.softvisiontestapp.data.model.ApiResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Handles network operations
 */
class NetworkDataSource private constructor(private val context: Context) {
    private val apiResponseData: MutableLiveData<ApiResponseData> = MutableLiveData()
    fun getApiResponseData(): MutableLiveData<ApiResponseData> {
        getAPIUpdates()
        return apiResponseData
    }

    private fun getAPIUpdates() {
        val service: NetworkService = RetrofitClientInstance.retrofitInstance.create(
            NetworkService::class.java
        )
        val call: Call<ApiResponseData> = service.getApiData()
        call.enqueue(object : Callback<ApiResponseData> {
            override fun onFailure(call: Call<ApiResponseData>, t: Throwable) {
                Toast.makeText(context, t.localizedMessage, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<ApiResponseData>,
                response: Response<ApiResponseData>
            ) {
                apiResponseData.postValue(response.body())
            }

        })
    }

    companion object {
        private var sInstance: NetworkDataSource? = null

        fun getInstance(context: Context): NetworkDataSource {
            if (sInstance == null) {
                sInstance =
                    NetworkDataSource(
                        context
                    )
            }
            return sInstance as NetworkDataSource
        }
    }

}
