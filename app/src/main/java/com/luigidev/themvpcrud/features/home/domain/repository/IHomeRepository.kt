package com.luigidev.themvpcrud.features.home.domain.repository

import android.content.Context
import com.luigidev.themvpcrud.core.Product

interface IHomeRepository {
    fun getProducts(context: Context): List<Product>
}
