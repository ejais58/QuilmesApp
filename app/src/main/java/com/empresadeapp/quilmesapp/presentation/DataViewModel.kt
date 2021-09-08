package com.empresadeapp.quilmesapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.empresadeapp.quilmesapp.data.model.Productos
import com.empresadeapp.quilmesapp.data.model.User

class DataViewModel: ViewModel() {
    private val user = MutableLiveData<User>()
    private val producto = MutableLiveData<Productos>()

    fun setUser(usuario : User){
        user.value = usuario
    }
    fun getUser(): LiveData<User> {
        return user
    }

    fun setProducto(item : Productos){
        producto.value = item
    }

    fun getProducto(): LiveData<Productos>{
        return producto
    }
}