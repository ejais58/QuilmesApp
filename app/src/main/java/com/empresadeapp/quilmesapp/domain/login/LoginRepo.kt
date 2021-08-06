package com.empresadeapp.quilmesapp.domain.login

import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.User
import com.google.firebase.firestore.FirebaseFirestore

interface LoginRepo {
    suspend fun login(numeroUsuario: String, password: String): User?
}