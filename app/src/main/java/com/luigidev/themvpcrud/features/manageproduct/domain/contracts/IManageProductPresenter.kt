package com.luigidev.themvpcrud.features.manageproduct.domain.contracts

import android.content.Context
import com.luigidev.themvpcrud.core.Product

interface IManageProductPresenter {
    fun saveProduct(context: Context, product: Product)
    fun editProduct(context: Context, id: Long)
}