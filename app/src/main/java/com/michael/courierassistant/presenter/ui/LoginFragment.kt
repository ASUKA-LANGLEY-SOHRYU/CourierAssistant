package com.michael.courierassistant.presenter.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.michael.courierassistant.R
import com.michael.courierassistant.databinding.LoginFragmentBinding

class LoginFragment : Fragment(R.layout.login_fragment) {

    lateinit var binding: LoginFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
   }

}