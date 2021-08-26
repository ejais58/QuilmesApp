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

    suspend fun getProductosQuilmes(): Result<List<Productos>> {
        val productoList = mutableListOf<Productos>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("Quilmes").get().await()
        for (producto in querySnapshot.documents){
            producto.toObject(Productos::class.java)?.let {
                productoList.add(it)
            }
        }
        return Result.Success(productoList)
    }

    suspend fun getProductosPepsi(): Result<List<Productos>> {
        val productoList = mutableListOf<Productos>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("Pepsi").get().await()
        for (producto in querySnapshot.documents){
            producto.toObject(Productos::class.java)?.let {
                productoList.add(it)
            }
        }
        return Result.Success(productoList)
    }

    suspend fun getProductosTorasso(): Result<List<Productos>> {
        val productoList = mutableListOf<Productos>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("Torasso").get().await()
        for (producto in querySnapshot.documents){
            producto.toObject(Productos::class.java)?.let {
                productoList.add(it)
            }
        }
        return Result.Success(productoList)
    }

    suspend fun getProductosAguas(): Result<List<Productos>> {
        val productoList = mutableListOf<Productos>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("Aguas").get().await()
        for (producto in querySnapshot.documents){
            producto.toObject(Productos::class.java)?.let {
                productoList.add(it)
            }
        }
        return Result.Success(productoList)
    }

    suspend fun getProductosVinos(): Result<List<Productos>> {
        val productoList = mutableListOf<Productos>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("Vinos").get().await()
        for (producto in querySnapshot.documents){
            producto.toObject(Productos::class.java)?.let {
                productoList.add(it)
            }
        }
        return Result.Success(productoList)
    }

}