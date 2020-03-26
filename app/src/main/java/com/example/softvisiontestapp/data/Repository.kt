package com.example.softvisiontestapp.data

import androidx.lifecycle.LiveData
import com.example.softvisiontestapp.data.model.ApiResponseData
import com.example.softvisiontestapp.data.network.NetworkDataSource

class Repository private constructor(private val networkDataSource: NetworkDataSource) {

    /*val apiResponse: LiveData<ApiResponseData>
        get() = networkDataSource.getNewsArticles()*/

    fun getAPIResponse(): LiveData<ApiResponseData> {
        return networkDataSource.getApiResponseData()
    }

    companion object {
        private var sInstance: Repository? = null

        fun getInstance(networkDataSource: NetworkDataSource): Repository? {
            if (sInstance == null) {
                sInstance = Repository(networkDataSource)
            }
            return sInstance
        }
    }

}