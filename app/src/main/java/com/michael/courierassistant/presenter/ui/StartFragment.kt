package com.michael.courierassistant.presenter.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.michael.courierassistant.R
import com.michael.courierassistant.databinding.FragmentMainBinding
import com.michael.courierassistant.databinding.StartFragmentBinding

class StartFragment : Fragment(R.layout.start_fragment) {

    private lateinit var binding: StartFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = StartFragmentBinding.bind(view)

        binding.apply {
            buttonLogin.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_loginFragment)
            }
            buttonRegistration.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_registrationFragment)
            }
            mainLogo.setOnClickListener {
                Toast.makeText(context, "dgsgsd", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
