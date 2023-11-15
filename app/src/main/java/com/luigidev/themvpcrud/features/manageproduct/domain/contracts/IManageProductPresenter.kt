package com.luigidev.themvpcrud.features.manageproduct.domain.contracts

import android.content.Context
import com.luigidev.themvpcrud.core.Product

interface IManageProductPresenter {
    fun saveProduct(context: Context, product: Product)
    fun getProduct(context: Context, id: Long)
    fun modifyProduct(context: Context, product: Product)
    fun eraseProduct(context: Context, id: Long)
    fun validateStrings(name: String, description: String, price: String): Boolean
}
