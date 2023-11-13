package com.luigidev.themvpcrud.features.manageproduct.data

import android.content.Context
import com.luigidev.themvpcrud.core.DatabaseHelper
import com.luigidev.themvpcrud.features.home.domain.models.Product
import com.luigidev.themvpcrud.features.manageproduct.domain.repository.IManageProductRepository

class ManageProductRepositoryImp: IManageProductRepository {
    override fun saveProduct(context: Context, product: Product) = DatabaseHelper(context).insertProduct(product)
}