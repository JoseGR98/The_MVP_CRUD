package com.luigidev.themvpcrud.features.manageproduct.domain.contracts

import com.luigidev.themvpcrud.core.Product

interface IManageProductView {
    fun showUploadSuccess()
    fun showUploadError()
    fun showEditMode(product: Product)
}
