package com.luigidev.themvpcrud.features.manageproduct.domain.repository

import android.content.Context
import com.luigidev.themvpcrud.core.ResultDatabase
import com.luigidev.themvpcrud.core.Product

interface IManageProductRepository {
    fun saveProduct(context: Context, product: Product): ResultDatabase<String>
    fun getProduct(context: Context, id: Long): ResultDatabase<Product>
}