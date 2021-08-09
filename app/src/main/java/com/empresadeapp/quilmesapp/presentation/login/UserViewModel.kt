package com.empresadeapp.quilmesapp.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.empresadeapp.quilmesapp.data.model.User

class UserViewModel: ViewModel() {
    private val user = MutableLiveData<User>()

    fun setUser(usuario : User){
        user.value = usuario
    }
    fun getUser(): LiveData<User> {
        return user
    }
}