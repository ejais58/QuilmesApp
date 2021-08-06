package com.empresadeapp.quilmesapp.domain.login

import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.User
import com.empresadeapp.quilmesapp.data.remote.login.LoginDataSource

class LoginRepoImpl(private val dataSource: LoginDataSource): LoginRepo{
    override suspend fun login(numeroUsuario: String, password: String): User? = dataSource.login(numeroUsuario,password)
}