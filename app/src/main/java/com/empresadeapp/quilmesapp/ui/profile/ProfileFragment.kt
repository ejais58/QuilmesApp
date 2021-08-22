package com.empresadeapp.quilmesapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.databinding.FragmentProfileBinding
import com.empresadeapp.quilmesapp.presentation.login.DataViewModel


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private val mainViewModel : DataViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        getUserData()
        logOut()
    }

    private fun logOut(){
        binding.btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }
    }

    private fun getUserData(){
        // Recibir datos de login
        mainViewModel.getUser().observe(viewLifecycleOwner, Observer { data ->
            binding.tvCodigo.text = "Código: ${data.codigo}"
            binding.tvApellido.text = "Apellido: ${data.apellido}"
            binding.tvNombre.text = "Nombre: ${data.nombre}"
            binding.tvDireccion.text = "Dirección: ${data.direccion}"
            binding.tvFactura.text = "Tipo de Factura: ${data.factura}"
            binding.tvRepartidor.text = "Repartidor: ${data.repartidor}"
        })
    }

}