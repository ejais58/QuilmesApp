package com.empresadeapp.quilmesapp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.databinding.FragmentHomeBinding

class HomeFragment() : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        destacado()
        quilmes()
        pepsi()
        torasso()
        aguas()
        vinos()
        salir()
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

    private fun torasso(){
        binding.buttonTorasso.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_torassoFragment)
        }
    }

    private fun aguas(){
        binding.buttonAgua.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_aguasFragment)
        }
    }

    private fun vinos() {
        binding.buttonVinos.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_vinosFragment)
        }
    }

    private fun salir(){
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val alert = AlertDialog.Builder(requireContext())
                alert.setTitle("Desea salir de QuilmesApp?").setPositiveButton("Si") { dialog, which ->
                    System.exit(0)
                }.setNegativeButton("Cancelar") { dialog, which ->

                }.show()

            }

        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
    
}