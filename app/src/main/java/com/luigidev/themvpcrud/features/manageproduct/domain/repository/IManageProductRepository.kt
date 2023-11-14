package com.luigidev.themvpcrud.features.manageproduct.domain.repository

import android.content.Context
import com.luigidev.themvpcrud.core.ResultDatabase
import com.luigidev.themvpcrud.core.Product

interface IManageProductRepository {
    fun createProduct(context: Context, product: Product): ResultDatabase<String>
    fun readProduct(context: Context, id: Long): ResultDatabase<Product>
    fun updateProduct(
        context: Context,
        product: Product
    ): ResultDatabase<String>

    fun getProducts(context: Context): List<Product>
}
