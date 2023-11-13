package com.luigidev.themvpcrud.features.home.ui

import com.luigidev.themvpcrud.features.home.data.HomeRepositoryImp
import com.luigidev.themvpcrud.features.home.domain.contracts.IHomePresenter
import com.luigidev.themvpcrud.features.home.domain.contracts.IHomeView

class HomePresenter(private val view: IHomeView): IHomePresenter {

    private val repository = HomeRepositoryImp()
    override fun loadProducts() {
        val products = repository.getProducts()
        view.showProducts(products)
    }
}