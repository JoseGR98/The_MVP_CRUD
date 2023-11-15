package com.luigidev.themvpcrud.features.manageproduct.ui

import android.content.Context
import com.luigidev.themvpcrud.core.ResultDatabase
import com.luigidev.themvpcrud.core.Product
import com.luigidev.themvpcrud.features.manageproduct.data.ManageProductRepositoryImp
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductPresenter
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductView

class ManageProductPresenter(private val view: IManageProductView) : IManageProductPresenter {

    private val repository = ManageProductRepositoryImp()

    override fun saveProduct(context: Context, product: Product) {
        when (repository.createProduct(context, product)) {
            ResultDatabase.Error -> view.showUploadError()
            is ResultDatabase.Success -> view.showUploadSuccess()
        }
    }

    override fun getProduct(context: Context, id: Long) {
        when (val result = repository.readProduct(context, id)) {
            ResultDatabase.Error -> view.showUploadError()
            is ResultDatabase.Success -> view.showEditMode(result.data)
        }
    }

    override fun modifyProduct(context: Context, product: Product) {
        when (repository.updateProduct(context, product)) {
            ResultDatabase.Error -> view.showUploadError()
            is ResultDatabase.Success -> view.showUploadSuccess()
        }
    }

    override fun eraseProduct(context: Context, id: Long) {
        when (repository.deleteProduct(context, id)) {
            ResultDatabase.Error -> view.showUploadError()
            is ResultDatabase.Success -> view.showUploadSuccess()
        }
    }

    override fun validateStrings(name: String, description: String, price: String): Boolean {
        return name.isNotEmpty() &&
                description.isNotEmpty() &&
                price.isNotEmpty()
    }

}
