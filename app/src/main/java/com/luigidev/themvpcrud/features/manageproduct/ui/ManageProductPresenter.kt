package com.luigidev.themvpcrud.features.manageproduct.ui

import android.content.Context
import com.luigidev.themvpcrud.features.home.domain.models.Product
import com.luigidev.themvpcrud.features.manageproduct.data.ManageProductRepositoryImp
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductPresenter
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductView

class ManageProductPresenter(private val view: IManageProductView): IManageProductPresenter {

    private val repository = ManageProductRepositoryImp()

    override fun saveProduct(context: Context, product: Product) {
        repository.saveProduct(context, product)
    }
}