package com.michael.courierassistant.presenter.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.michael.courierassistant.R
import com.michael.courierassistant.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.setOnClickListener {
            binding.text.setBackgroundColor(Color.BLUE)
        }
    }
}