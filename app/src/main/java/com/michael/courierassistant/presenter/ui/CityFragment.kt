package com.michael.courierassistant.presenter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michael.courierassistant.R


class CityFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_select)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cities = listOf(
            City("Москва"),
            City("Санкт-Петербург"),
            City("Екатеринбург"),
            City("Казань"),

            )

        val adapter = CityAdapter(cities)
        recyclerView.adapter = adapter
    }

}