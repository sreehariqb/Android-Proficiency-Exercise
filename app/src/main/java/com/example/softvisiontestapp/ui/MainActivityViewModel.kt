package com.example.softvisiontestapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.softvisiontestapp.data.model.Row

class MainActivityViewModel: ViewModel() {
    lateinit var rows: LiveData<List<Row>>

}