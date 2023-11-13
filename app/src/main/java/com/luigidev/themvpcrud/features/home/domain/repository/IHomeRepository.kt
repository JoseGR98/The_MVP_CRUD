package com.luigidev.themvpcrud.features.home.domain.repository

import android.content.Context
import com.luigidev.themvpcrud.features.home.domain.models.Product

interface IHomeRepository {
    fun getProducts(context: Context): List<Product>
}