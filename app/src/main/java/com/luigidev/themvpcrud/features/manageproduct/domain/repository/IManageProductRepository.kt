package com.luigidev.themvpcrud.features.manageproduct.domain.repository

import android.content.Context
import com.luigidev.themvpcrud.features.home.domain.models.Product

interface IManageProductRepository {
    fun saveProduct(context: Context, product: Product)
}