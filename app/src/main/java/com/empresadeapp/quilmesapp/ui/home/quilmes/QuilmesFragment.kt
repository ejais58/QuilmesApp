package com.empresadeapp.quilmesapp.ui.home.quilmes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.empresadeapp.quilmesapp.R
import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.remote.home.HomeDataSource
import com.empresadeapp.quilmesapp.databinding.FragmentQuilmesBinding
import com.empresadeapp.quilmesapp.domain.home.HomeRepoImpl
import com.empresadeapp.quilmesapp.presentation.home.HomeViewModel
import com.empresadeapp.quilmesapp.presentation.home.HomeViewModelFactory
import com.empresadeapp.quilmesapp.ui.home.adaptador.GlobalAdapter


class QuilmesFragment : Fragment(R.layout.fragment_quilmes) {

    private lateinit var binding: FragmentQuilmesBinding
    private val viewModel by viewModels<HomeViewModel>{ HomeViewModelFactory(HomeRepoImpl(HomeDataSource())) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuilmesBinding.bind(view)
        quilmesRecycler()

    }

    private fun quilmesRecycler(){
        viewModel.fetchProductoQuilmes().observe(viewLifecycleOwner, Observer { result ->
            when (result){
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvQuilmes.adapter = GlobalAdapter(result.data)
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "error ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}