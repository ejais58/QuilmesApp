package com.empresadeapp.quilmesapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.domain.home.HomeRepo
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class HomeViewModel(private val repo: HomeRepo): ViewModel() {
    fun fetchProductoDestacados() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getProductosDestacados())
        } catch (e: Exception){
            emit(Result.Failure(e))
        }
    }

    fun fetchProductoQuilmes() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getProductosQuilmes())
        } catch (e: Exception){
            emit(Result.Failure(e))
        }
    }

    fun fetchProductoPepsi() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getProductosPepsi())
        } catch (e: Exception){
            emit(Result.Failure(e))
        }
    }

    fun fetchProductoTorasso() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getProductosTorasso())
        } catch (e: Exception){
            emit(Result.Failure(e))
        }
    }

    fun fetchProductoAguas() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getProductosAguas())
        } catch (e: Exception){
            emit(Result.Failure(e))
        }
    }

    fun fetchProductoVinos() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getProductosVinos())
        } catch (e: Exception){
            emit(Result.Failure(e))
        }
    }


}

class HomeViewModelFactory(private val repo: HomeRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repo) as T
    }
}