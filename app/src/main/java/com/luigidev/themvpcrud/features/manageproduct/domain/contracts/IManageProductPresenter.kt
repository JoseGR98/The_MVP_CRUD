package com.luigidev.themvpcrud.features.manageproduct.domain.contracts

import android.content.Context
import com.luigidev.themvpcrud.features.home.domain.models.Product

interface IManageProductPresenter {
    fun saveProduct(context: Context, product: Product)
}