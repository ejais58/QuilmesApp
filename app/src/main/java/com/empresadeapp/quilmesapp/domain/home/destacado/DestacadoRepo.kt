package com.empresadeapp.quilmesapp.domain.home.destacado

import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.Productos

interface DestacadoRepo {
    suspend fun getProductosDestacados(): Result<List<Productos>>
}