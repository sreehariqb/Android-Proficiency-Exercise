package com.example.softvisiontestapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.softvisiontestapp.R
import com.example.softvisiontestapp.data.model.ApiResponseData
import com.example.softvisiontestapp.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    private val listAdapter = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListView()
        setUpSwipeRefresh()
        val factory: MainActivityViewModelFactory = InjectorUtils.provideMainActivityViewModelFactory(applicationContext)
        //bind view model and activity
        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        viewModel.apiResponseData.observe(this, Observer<ApiResponseData> { apiData ->
            //update data list in adapter
            listAdapter.rows = apiData.rows
            //set actionbar title
            supportActionBar?.title = apiData.title
            //hide progress refresh after data has been updated
            swipeRefreshLayout.isRefreshing = false
        })
        viewModel.getApiData()
    }

    /**
     * show progress refresh and set on refresh listener
     */
    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.getApiData()
        }
    }

    /**
     * set up list view and attach adapter
     */
    private fun setUpListView() {
        val listView: RecyclerView = findViewById(R.id.dataListView)
        listView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        listView.adapter = listAdapter
    }
}
