package com.empresadeapp.quilmesapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.domain.home.destacado.DestacadoRepo
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class HomeViewModel(private val repo: DestacadoRepo): ViewModel() {
    fun fetchProductoList() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getProductosDestacados())
        } catch (e: Exception){
            emit(Result.Failure(e))
        }
    }
}

class HomeViewModelFactory(private val repo: DestacadoRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repo) as T
    }
}