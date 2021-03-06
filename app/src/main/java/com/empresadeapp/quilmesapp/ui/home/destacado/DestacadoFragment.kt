package com.empresadeapp.quilmesapp.ui.home.destacado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.remote.home.HomeDataSource
import com.empresadeapp.quilmesapp.databinding.FragmentDestacadoBinding
import com.empresadeapp.quilmesapp.domain.home.HomeRepoImpl
import com.empresadeapp.quilmesapp.presentation.home.HomeViewModel
import com.empresadeapp.quilmesapp.presentation.home.HomeViewModelFactory
import com.empresadeapp.quilmesapp.ui.home.destacado.adapter.DestacadoAdapter


class DestacadoFragment : Fragment(R.layout.fragment_destacado) {

    private lateinit var binding: FragmentDestacadoBinding
    private val viewModel by viewModels<HomeViewModel>{ HomeViewModelFactory(HomeRepoImpl(HomeDataSource())) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDestacadoBinding.bind(view)
        destacadoRecycler()

    }

    private fun destacadoRecycler() {
        viewModel.fetchProductoDestacados().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvDestacado.layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.rvDestacado.adapter = DestacadoAdapter(result.data)
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "error ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

}