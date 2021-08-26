package com.empresadeapp.quilmesapp.domain.home

import com.empresadeapp.quilmesapp.core.Result
import com.empresadeapp.quilmesapp.data.model.Productos
import com.empresadeapp.quilmesapp.data.remote.home.HomeDataSource

class HomeRepoImpl(private val dataSource : HomeDataSource): HomeRepo {
    override suspend fun getProductosDestacados(): Result<List<Productos>> = dataSource.getProductosDestacados()
    override suspend fun getProductosQuilmes(): Result<List<Productos>> = dataSource.getProductosQuilmes()
    override suspend fun getProductosPepsi(): Result<List<Productos>> = dataSource.getProductosPepsi()
    override suspend fun getProductosTorasso(): Result<List<Productos>> = dataSource.getProductosTorasso()
    override suspend fun getProductosAguas(): Result<List<Productos>> = dataSource.getProductosAguas()
    override suspend fun getProductosVinos(): Result<List<Productos>> = dataSource.getProductosVinos()
}