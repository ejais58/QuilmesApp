package com.empresadeapp.quilmesapp.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.data.remote.login.LoginDataSource
import com.empresadeapp.quilmesapp.databinding.FragmentLoginBinding
import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.domain.login.LoginRepoImpl
import com.empresadeapp.quilmesapp.presentation.login.LoginViewModel
import com.empresadeapp.quilmesapp.presentation.login.LoginViewModelFactory
import com.empresadeapp.quilmesapp.presentation.DataViewModel


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel> {LoginViewModelFactory(LoginRepoImpl(LoginDataSource())) }
    private val mainViewModel : DataViewModel by activityViewModels()


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
            login(numeroUsuario,password)
        }
    }

    private fun validation(numeroUsuario: String, password: String) {
        if (numeroUsuario.isEmpty()){
            binding.editTextUsuario.error = "Ingrese numero de cliente"
            return
        }
        if (password.isEmpty()){
            binding.editTextPassword.error = "Ingrese contraseña"
            return
        }
    }

    private fun login(numeroUsuario: String,password: String) {
        viewModel.login(numeroUsuario,password).observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                    binding.btnSignin.isEnabled = false
                }
                is Result.Success -> {
                    // Enviar datos a profile
                    if (result.data.contra == password){
                        mainViewModel.setUser(result.data)
                        Log.d("hola1","${result.data}")
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        binding.progressbar.visibility = View.GONE
                        binding.btnSignin.isEnabled = true
                    }
                }
                is Result.Failure -> {
                    binding.progressbar.visibility = View.GONE
                    binding.btnSignin.isEnabled = true
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
            }
        } )
    }
}

