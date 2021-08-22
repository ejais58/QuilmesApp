package com.empresadeapp.quilmesapp.data.remote.home

import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.Productos
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeDataSource {
    suspend fun getProductosDestacados(): Result<List<Productos>>{
        val productoList = mutableListOf<Productos>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("Destacado").get().await()
        for (producto in querySnapshot.documents){
            producto.toObject(Productos::class.java)?.let {
                productoList.add(it)
            }
        }
        return Result.Success(productoList)
    }
}