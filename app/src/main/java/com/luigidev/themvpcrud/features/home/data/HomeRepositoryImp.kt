package com.luigidev.themvpcrud.features.home.data

import android.content.Context
import com.luigidev.themvpcrud.core.DatabaseHelper
import com.luigidev.themvpcrud.features.home.domain.models.Product
import com.luigidev.themvpcrud.features.home.domain.repository.IHomeRepository

class HomeRepositoryImp() : IHomeRepository {
    override fun getProducts(context: Context): List<Product> = DatabaseHelper(context).getProducts()
}