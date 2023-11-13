package com.luigidev.themvpcrud.features.manageproduct.domain.contracts

import com.luigidev.themvpcrud.features.home.domain.models.Product

interface IManageProductPresenter {
    fun saveProduct(product: Product)
}