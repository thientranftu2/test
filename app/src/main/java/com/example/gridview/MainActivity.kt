package com.example.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.GridView
import com.example.gridview.adapter.CustomAdapter
import com.example.gridview.model.Country
import android.content.pm.ApplicationInfo

import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.util.Log
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayListCountries = ArrayList<Country>()
//        var country1 = Country(R.drawable.anhflag, "Anh")
//        var country2 = Country(R.drawable.my, "Messi")
//        var country3 = Country(R.drawable.ducflag, "Đức")
//        var country4 = Country(R.drawable.hanquoc, "Hàn Quốc")
//        var country5 = Country(R.drawable.my, "Mỹ")
//        var country6 = Country(R.drawable.nhatban, "Nhật Bản")
//        var country7 = Country(R.drawable.anhflag1, "Anh")
//        var country8 = Country(R.drawable.my, "Messi")
//        var country9 = Country(R.drawable.ducflag3, "Đức")
//        var country10 = Country(R.drawable.hanquoc4, "Hàn Quốc")
//        var country11 = Country(R.drawable.my5, "Mỹ")
//        var country12 = Country(R.drawable.nhatban6, "Nhật Bản")
//        var country13 = Country(R.drawable.ducflag3, "Đức")
//        var country14 = Country(R.drawable.hanquoc4, "Hàn Quốc")
//        var country15 = Country(R.drawable.my5, "Mỹ")
//        var country16 = Country(R.drawable.nhatban6, "Nhật Bản")
//        var country17 = Country(R.drawable.ducflag3, "Đức")
//        var country18 = Country(R.drawable.hanquoc4, "Hàn Quốc")
//
//        arrayListCountries.add(country1)
//        arrayListCountries.add(country2)
//        arrayListCountries.add(country3)
//        arrayListCountries.add(country4)
//        arrayListCountries.add(country5)
//        arrayListCountries.add(country6)
//        arrayListCountries.add(country7)
//        arrayListCountries.add(country8)
//        arrayListCountries.add(country9)
//        arrayListCountries.add(country10)
//        arrayListCountries.add(country12)
//        arrayListCountries.add(country13)
//        arrayListCountries.add(country14)
//        arrayListCountries.add(country15)
//        arrayListCountries.add(country16)
//        arrayListCountries.add(country17)
//        arrayListCountries.add(country18)
//        arrayListCountries.add(country11)

        val pm = packageManager
//get a list of installed apps.
//get a list of installed apps.
        val packages = pm.getInstalledApplications(PackageManager.GET_META_DATA)
        var image: Drawable
        var name: CharSequence
        for (packageInfo in packages) {
            image = packageInfo.loadIcon(pm)
            name = packageInfo.loadLabel(pm)
            var country = Country(image, name)
            arrayListCountries.add(country)
//            Log.d("TAG", "Installed package :" + packageInfo.packageName)
//            Log.d("TAG", "Source dir : " + packageInfo.sourceDir)
//            Log.d("TAG", "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName))
        }
        // Sắp xếp giảm dần string properties
//        arrayListCountries.sortBy { it.nameCountry.first() }
        // Sắp xếp tăng dần string properties
        arrayListCountries.sortByDescending { it.nameCountry.first() }
        var gridView: GridView = findViewById(R.id.idGridViewCountries)
        var adapter = CustomAdapter(this, arrayListCountries)
        gridView.adapter = adapter
    }
}