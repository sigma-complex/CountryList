package com.hiddenDimension.countryInfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hiddenDimension.countryInfo.R
import com.hiddenDimension.countryInfo.dataClass.CountryListItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_list_row.view.*

class CountryListAdapter() : RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {
    private var countryList: List<CountryListItem>? = null

    fun setCountryList(countryList: List<CountryListItem>?) {
        this.countryList = countryList
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val flagImage = view.flagImageView
        val countryName = view.countryNameTextView
        val countryCap = view.countryCapitalNameTextView
        val countryReg = view.countryRegionNameTextView

        fun bind(data: CountryListItem) {

            countryName.text = data.name + "   " + data.alpha2Code
            countryCap.text = "Capital: " + data.capital
            countryReg.text = "Region: " + data.region

            Picasso.get().load(data.flags.png).into(flagImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(countryList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return countryList?.size ?: 0
    }
}