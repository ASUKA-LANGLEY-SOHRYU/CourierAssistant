package com.michael.courierassistant.presenter.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.michael.courierassistant.R

class StartFragment : Fragment(R.layout.start_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton: Button = view.findViewById(R.id.button_login)
        val registrationButton: Button = view.findViewById(R.id.button_registration)

        loginButton.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        registrationButton.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }

    }

}
