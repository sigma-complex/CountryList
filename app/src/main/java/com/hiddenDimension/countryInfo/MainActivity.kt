package com.hiddenDimension.countryInfo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hiddenDimension.countryInfo.adapter.CountryListAdapter
import com.hiddenDimension.countryInfo.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    lateinit var recyclerAdapter: CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        countryListRecyclerView.layoutManager = LinearLayoutManager(this)

        recyclerAdapter = CountryListAdapter()
        countryListRecyclerView.adapter = recyclerAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel() {
        val vm: MainActivityViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)

        vm.getLiveDataObserver().observe(this) {
            recyclerAdapter.setCountryList(it)
            recyclerAdapter.notifyDataSetChanged()

        }

        vm.makeAPICall()

    }


}