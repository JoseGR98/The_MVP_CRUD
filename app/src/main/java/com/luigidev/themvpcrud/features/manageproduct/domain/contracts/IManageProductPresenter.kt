package com.luigidev.themvpcrud.features.manageproduct.domain.contracts

import android.content.Context
import com.luigidev.themvpcrud.core.Product

interface IManageProductPresenter {
    fun saveProduct(context: Context, product: Product)
    fun readProduct(context: Context, id: Long)
    fun editProduct(context: Context, product: Product)

}
