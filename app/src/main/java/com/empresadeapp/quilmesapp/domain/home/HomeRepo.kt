package com.empresadeapp.quilmesapp.domain.home

import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.Productos

interface HomeRepo {
    suspend fun getProductosDestacados(): Result<List<Productos>>
    suspend fun getProductosQuilmes(): Result<List<Productos>>
    suspend fun getProductosPepsi(): Result<List<Productos>>
    suspend fun getProductosTorasso(): Result<List<Productos>>
    suspend fun getProductosAguas(): Result<List<Productos>>
    suspend fun getProductosVinos(): Result<List<Productos>>
}