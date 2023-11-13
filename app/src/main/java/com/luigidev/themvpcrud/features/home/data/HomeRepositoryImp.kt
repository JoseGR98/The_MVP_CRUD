package com.luigidev.themvpcrud.features.home.data

import com.luigidev.themvpcrud.features.home.domain.models.Product
import com.luigidev.themvpcrud.features.home.domain.repository.IHomeRepository

class HomeRepositoryImp : IHomeRepository {
    override fun getProducts(): List<Product> {
        return listOf(
            Product(id = "1", name = "Product", description = "Example", price = 5),
            Product(id = "2", name = "Product2", description = "Example2", price = 7),
            Product(id = "3", name = "Product3", description = "Example3", price = 8),
            Product(id = "4", name = "Product4", description = "Example4", price = 9)
        )
    }
}