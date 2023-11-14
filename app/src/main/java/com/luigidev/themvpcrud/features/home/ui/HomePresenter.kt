package com.luigidev.themvpcrud.features.home.ui

import android.content.Context
import com.luigidev.themvpcrud.features.home.data.HomeRepositoryImp
import com.luigidev.themvpcrud.features.home.domain.contracts.IHomePresenter
import com.luigidev.themvpcrud.features.home.domain.contracts.IHomeView

class HomePresenter(private val view: IHomeView) : IHomePresenter {

    private val repository = HomeRepositoryImp()
    override fun loadProducts(context: Context) {
        val products = repository.getProducts(context)
        view.showProducts(products)
    }
}
