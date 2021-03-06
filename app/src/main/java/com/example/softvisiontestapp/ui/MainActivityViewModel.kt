package com.example.softvisiontestapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.softvisiontestapp.data.Repository
import com.example.softvisiontestapp.data.model.APIResponse
import com.example.softvisiontestapp.data.model.APIResponseData

/**
 * ViewModel class that holds lifecycle aware data for [MainActivity]
 */
class MainActivityViewModel(private val repository: Repository) : ViewModel() {
    //liveData that holds API response data
    var apiResponseData: MutableLiveData<APIResponse> = MutableLiveData()
    init {
        getApiData()
    }

    /**
     * update the liveData from repository
     */
    fun getApiData() {
        apiResponseData = repository.getAPIResponse() as MutableLiveData<APIResponse>
    }
}