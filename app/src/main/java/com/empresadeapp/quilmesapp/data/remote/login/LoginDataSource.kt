package com.empresadeapp.quilmesapp.data.remote.login

import android.util.Log
import android.widget.Toast
import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class LoginDataSource {
    suspend fun login(numeroUsuario: String, password: String): User  {
        val db = FirebaseFirestore.getInstance()
        val document = db.collection("Clientes").document(numeroUsuario).get().await()
        val user = document.toObject(User::class.java)
        return user!!

    }
}
