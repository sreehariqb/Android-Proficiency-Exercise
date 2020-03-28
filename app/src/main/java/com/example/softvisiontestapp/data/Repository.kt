package com.example.softvisiontestapp.data

import androidx.lifecycle.LiveData
import com.example.softvisiontestapp.data.model.APIResponse
import com.example.softvisiontestapp.data.model.APIResponseData
import com.example.softvisiontestapp.data.network.NetworkDataSource

/**
 * A single source of truth for data
 */
class Repository private constructor(private val networkDataSource: NetworkDataSource) {

    //return data from network class
    fun getAPIResponse(): LiveData<APIResponse> {
        return networkDataSource.getAPIResponseData()
    }

    companion object {
        private var sInstance: Repository? = null

        fun getInstance(networkDataSource: NetworkDataSource): Repository {
            if (sInstance == null) {
                sInstance = Repository(networkDataSource)
            }
            return sInstance as Repository
        }
    }

}