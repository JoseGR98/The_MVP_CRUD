package com.luigidev.themvpcrud.features.home.domain.repository

import com.luigidev.themvpcrud.features.home.domain.models.Product

interface IHomeRepository {
    fun getProducts(): List<Product>
}