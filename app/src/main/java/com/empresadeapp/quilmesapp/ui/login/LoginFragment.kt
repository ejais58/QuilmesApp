package com.empresadeapp.quilmesapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        doLogin()
    }

    private fun doLogin() {
        binding.btnSignin.setOnClickListener {
            val numeroUsuario = binding.editTextUsuario.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            validation(numeroUsuario,password)
        }
    }

    private fun validation(numeroUsuario: String, password: String) {

    }

}