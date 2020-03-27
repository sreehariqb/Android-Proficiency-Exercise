package com.example.softvisiontestapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.softvisiontestapp.data.Repository
import com.example.softvisiontestapp.data.model.ApiResponseData

class MainActivityViewModel(private val repository: Repository) : ViewModel() {
    var apiResponseData: LiveData<ApiResponseData> = this.repository.getAPIResponse()
}