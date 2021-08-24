package com.empresadeapp.quilmesapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        destacado()
        quilmes()
        pepsi()
    }

    private fun destacado(){
        binding.buttonPromo.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_destacadoFragment)
        }
    }

    private fun quilmes(){
        binding.buttonQuilmes.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_quilmesFragment)
        }
    }

    private fun pepsi(){
        binding.buttonPepsi.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pepsiFragment)
        }
    }

}