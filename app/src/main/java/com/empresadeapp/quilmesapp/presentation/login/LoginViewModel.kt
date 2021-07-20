package com.empresadeapp.quilmesapp.presentation.login

import com.empresadeapp.quilmesapp.data.remote.login.LoginDataSource
import com.empresadeapp.quilmesapp.domain.login.LoginRepo
import com.google.firebase.firestore.FirebaseFirestore

class LoginViewModel(private val dataSource: LoginDataSource): LoginRepo {

}