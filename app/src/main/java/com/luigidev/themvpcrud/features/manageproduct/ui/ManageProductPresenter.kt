package com.luigidev.themvpcrud.features.manageproduct.ui

import android.util.Log
import com.luigidev.themvpcrud.features.home.domain.models.Product
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductPresenter
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductView

class ManageProductPresenter(private val view: IManageProductView): IManageProductPresenter {
    override fun saveProduct(product: Product) {
        Log.i("Presenter", "PRoduct que llega $product")
    }
}