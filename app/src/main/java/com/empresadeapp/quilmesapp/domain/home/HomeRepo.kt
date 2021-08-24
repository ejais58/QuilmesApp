package com.empresadeapp.quilmesapp.domain.home

import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.Productos

interface HomeRepo {
    suspend fun getProductosDestacados(): Result<List<Productos>>
    suspend fun getProductosQuilmes(): Result<List<Productos>>
    suspend fun getProductosPepsi(): Result<List<Productos>>
}