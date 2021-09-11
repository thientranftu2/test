package com.example.gridview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gridview.R
import com.example.gridview.model.Country

class CustomAdapter(var context: Context, var arrayListCountry: ArrayList<Country>): BaseAdapter() {
    override fun getCount(): Int {
        return arrayListCountry.size
    }

    override fun getItem(p0: Int): Any {
        return arrayListCountry.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }
    class ViewHolder(var row: View){
        var imageViewCountry: ImageView = row.findViewById(R.id.idImageViewCountry)
        var txtViewNameCountry: TextView = row.findViewById(R.id.idTextViewCountry)
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var view: View
        var viewHolder: ViewHolder
        if (convertView == null){
            var layoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.item_country,null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        var country: Country = getItem(position) as Country
        if (country.imageCountry != null) {
            viewHolder.imageViewCountry.setImageDrawable(country.imageCountry) //setImageResource(country.imageCountry)
        }
        viewHolder.txtViewNameCountry.text = country.nameCountry

        return view
    }
}