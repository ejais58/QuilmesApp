package com.empresadeapp.quilmesapp.ui.home.vinos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.remote.home.HomeDataSource
import com.empresadeapp.quilmesapp.databinding.FragmentVinosBinding
import com.empresadeapp.quilmesapp.domain.home.HomeRepoImpl
import com.empresadeapp.quilmesapp.presentation.home.HomeViewModel
import com.empresadeapp.quilmesapp.presentation.home.HomeViewModelFactory
import com.empresadeapp.quilmesapp.ui.home.adaptador.GlobalAdapter


class VinosFragment : Fragment(R.layout.fragment_vinos) {

    private lateinit var binding: FragmentVinosBinding
    private val viewModel by viewModels<HomeViewModel>{ HomeViewModelFactory(HomeRepoImpl(HomeDataSource())) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVinosBinding.bind(view)
        recyclerVinos()
    }

    private fun recyclerVinos() {
        viewModel.fetchProductoVinos().observe(viewLifecycleOwner, Observer { result ->
            when (result){
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvVinos.adapter = GlobalAdapter(result.data)
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "error ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


}