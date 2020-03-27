package com.example.softvisiontestapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.softvisiontestapp.R
import com.example.softvisiontestapp.data.model.ApiResponseData
import com.example.softvisiontestapp.utils.InjectorUtils

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val factory: MainActivityViewModelFactory = InjectorUtils.provideMainActivityViewModelFactory(applicationContext)
        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        viewModel.apiResponseData.observe(this, Observer<ApiResponseData> { apiData ->
            apiData.rows
            Toast.makeText(this, apiData.rows[0].description, Toast.LENGTH_LONG).show()
        })
    }
}
