package com.example.softvisiontestapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softvisiontestapp.R
import com.example.softvisiontestapp.data.model.APIResponse
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
        val factory: MainActivityViewModelFactory = InjectorUtils.provideMainActivityViewModelFactory()
        //bind view model and activity
        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        viewModel.apiResponseData.observe(this, Observer<APIResponse> { apiResponse ->
            if(apiResponse.data != null) {
                //update data list in adapter
                listAdapter.rows = apiResponse.data.rows
                //set actionbar title
                supportActionBar?.title = apiResponse.data.title
            } else if(apiResponse.throwable != null) {
                //show error message if data is null
                Toast.makeText(this, apiResponse.throwable.localizedMessage, Toast.LENGTH_LONG).show()
            }
            //hide progress refresh after data has been updated or error message shown
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
