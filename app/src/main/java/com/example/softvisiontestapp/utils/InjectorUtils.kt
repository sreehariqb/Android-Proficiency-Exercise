package com.example.softvisiontestapp.utils

import com.example.softvisiontestapp.data.Repository
import com.example.softvisiontestapp.data.network.NetworkDataSource
import com.example.softvisiontestapp.ui.MainActivityViewModelFactory

/**
 * Injects dependencies as needed
 */
object InjectorUtils {
    fun provideMainActivityViewModelFactory(): MainActivityViewModelFactory {
        val repository: Repository = provideRepository()
        return MainActivityViewModelFactory(repository)
    }

    private fun provideRepository(): Repository {
        return Repository.getInstance(NetworkDataSource)
    }
}