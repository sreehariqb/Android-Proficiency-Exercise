package com.example.softvisiontestapp.ui

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.softvisiontestapp.data.Repository

/**
 *Factory method that allows us to create a ViewModel with a constructor that takes a [Repository]
 */
class MainActivityViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}