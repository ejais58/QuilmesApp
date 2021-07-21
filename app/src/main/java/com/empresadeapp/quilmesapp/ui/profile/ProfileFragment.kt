package com.empresadeapp.quilmesapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        logOut()
    }

    private fun logOut(){
        binding.btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }
    }

}