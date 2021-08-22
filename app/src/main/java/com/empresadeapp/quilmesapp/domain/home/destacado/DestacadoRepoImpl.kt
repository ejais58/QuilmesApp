package com.empresadeapp.quilmesapp.domain.home.destacado

import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.Productos
import com.empresadeapp.quilmesapp.data.remote.home.HomeDataSource

class DestacadoRepoImpl(private val dataSource : HomeDataSource): DestacadoRepo {
    override suspend fun getProductosDestacados(): Result<List<Productos>> = dataSource.getProductosDestacados()
}