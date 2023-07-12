package com.michael.courierassistant.presenter.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.michael.courierassistant.R
import com.michael.courierassistant.databinding.FragmentMainBinding
import com.michael.courierassistant.databinding.StartFragmentBinding

class StartFragment : Fragment(R.layout.start_fragment) {

    private var _binding: StartFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = StartFragmentBinding.bind(view)

        val loginButton: Button = binding.buttonLogin
        val registrationButton: Button = binding.buttonRegistration
        val mainButton: Button = binding.buttonMain

        loginButton.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        registrationButton.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
        mainButton.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }

    }

}
