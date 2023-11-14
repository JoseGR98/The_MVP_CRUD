package com.luigidev.themvpcrud.features.home.domain.contracts

import com.luigidev.themvpcrud.core.Product

interface IHomeView {
    fun showProducts(products: List<Product>)
    fun hideFab(isVisible: Boolean)
    fun goToManageProduct()
    fun goToEditProduct(id: Long)
}
