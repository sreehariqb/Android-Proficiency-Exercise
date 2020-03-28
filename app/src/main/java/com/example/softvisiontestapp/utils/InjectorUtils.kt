package com.example.softvisiontestapp.utils

import android.content.Context
import com.example.softvisiontestapp.data.Repository
import com.example.softvisiontestapp.data.network.NetworkDataSource
import com.example.softvisiontestapp.ui.MainActivityViewModel
import com.example.softvisiontestapp.ui.MainActivityViewModelFactory

/**
 * Injects dependencies as needed
 */
object InjectorUtils {
    fun provideMainActivityViewModelFactory(context: Context): MainActivityViewModelFactory {
        val repository: Repository = provideRepository(context)
        return MainActivityViewModelFactory(repository)
    }

    private fun provideRepository(context: Context): Repository {
        val networkDataSource: NetworkDataSource = NetworkDataSource.getInstance(context)
        return Repository.getInstance(networkDataSource)
    }
}