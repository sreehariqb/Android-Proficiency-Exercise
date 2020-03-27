package com.example.softvisiontestapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.softvisiontestapp.data.Repository
import com.example.softvisiontestapp.data.model.ApiResponseData

class MainActivityViewModel(private val repository: Repository) : ViewModel() {
    var apiResponseData: MutableLiveData<ApiResponseData> = MutableLiveData()
    init {
        getApiData()
    }

    fun getApiData() {
        apiResponseData = repository.getAPIResponse() as MutableLiveData<ApiResponseData>
    }
}