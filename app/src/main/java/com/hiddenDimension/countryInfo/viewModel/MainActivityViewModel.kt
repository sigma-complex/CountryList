package com.hiddenDimension.countryInfo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hiddenDimension.countryInfo.dataClass.CountryListItem
import com.hiddenDimension.countryInfo.retrofit.CountryServiceInterface
import com.hiddenDimension.countryInfo.retrofit.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var liveDataList: MutableLiveData<List<CountryListItem>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<CountryListItem>> {

        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val countryService = retroInstance.create(CountryServiceInterface::class.java)

        val countryList = countryService.getAllCountryList()
        countryList.enqueue(object : Callback<List<CountryListItem>?> {
            override fun onResponse(
                call: Call<List<CountryListItem>?>,
                response: Response<List<CountryListItem>?>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CountryListItem>?>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }
}