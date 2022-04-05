package com.hiddenDimension.countryInfo.retrofit

import com.hiddenDimension.countryInfo.dataClass.CountryListItem
import retrofit2.Call
import retrofit2.http.GET

interface CountryServiceInterface {

    @GET("all")
    fun getAllCountryList(): Call<List<CountryListItem>>
}