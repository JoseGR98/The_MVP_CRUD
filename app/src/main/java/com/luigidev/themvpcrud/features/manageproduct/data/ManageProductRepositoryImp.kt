package com.luigidev.themvpcrud.features.manageproduct.data

import android.content.Context
import com.luigidev.themvpcrud.core.DatabaseHelper
import com.luigidev.themvpcrud.core.Product
import com.luigidev.themvpcrud.core.ResultDatabase
import com.luigidev.themvpcrud.features.manageproduct.domain.repository.IManageProductRepository

class ManageProductRepositoryImp : IManageProductRepository {
    override fun createProduct(context: Context, product: Product) =
        DatabaseHelper(context).insertProduct(product)

    override fun readProduct(context: Context, id: Long): ResultDatabase<Product> =
        DatabaseHelper(context).getProductById(id)

    override fun updateProduct(
        context: Context,
        product: Product
    ): ResultDatabase<String> =
        DatabaseHelper(context).updateProduct(product)

    override fun getProducts(context: Context): List<Product> =
        DatabaseHelper(context).getProducts()

}
