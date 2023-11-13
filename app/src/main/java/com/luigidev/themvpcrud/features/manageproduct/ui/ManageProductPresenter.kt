package com.luigidev.themvpcrud.features.manageproduct.ui

import android.content.Context
import com.luigidev.themvpcrud.core.ResultDatabase
import com.luigidev.themvpcrud.features.home.domain.models.Product
import com.luigidev.themvpcrud.features.manageproduct.data.ManageProductRepositoryImp
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductPresenter
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductView

class ManageProductPresenter(private val view: IManageProductView): IManageProductPresenter {

    private val repository = ManageProductRepositoryImp()

    override fun saveProduct(context: Context, product: Product) {
        when(repository.saveProduct(context, product)){
            ResultDatabase.Error -> view.showUploadError()
            is ResultDatabase.Success -> view.showUploadSuccess()
        }
    }

}