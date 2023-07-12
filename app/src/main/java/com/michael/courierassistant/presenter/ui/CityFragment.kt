package com.michael.courierassistant.presenter.ui

import CityAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.michael.courierassistant.R
import com.michael.courierassistant.databinding.CitySelectBinding
import com.michael.courierassistant.databinding.FragmentMainBinding


class CityFragment : AppCompatActivity() {

    private var _binding: CitySelectBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_select)

        val recyclerView: RecyclerView = binding.recyclerView
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