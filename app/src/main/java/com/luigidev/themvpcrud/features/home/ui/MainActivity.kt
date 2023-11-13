package com.luigidev.themvpcrud.features.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.luigidev.themvpcrud.features.manageproduct.ui.ManageProductFragment
import com.luigidev.themvpcrud.R
import com.luigidev.themvpcrud.databinding.ActivityMainBinding
import com.luigidev.themvpcrud.features.home.domain.contracts.IHomeView
import com.luigidev.themvpcrud.features.home.domain.models.Product

class MainActivity : AppCompatActivity(), IHomeView {

    private lateinit var mBinding: ActivityMainBinding
    private val presenter = HomePresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.fab.setOnClickListener {
            goToManageProduct()
        }

        presenter.loadProducts()
    }

    override fun showProducts(products: List<Product>) {
        Log.i("View", "PRoducts $products")
    }

    override fun hideFab(isVisible: Boolean) {
        if (isVisible) mBinding.fab.show() else mBinding.fab.hide()
    }

    override fun goToManageProduct() {
        val fragment = ManageProductFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        hideFab(false)
    }

    //    private fun goToManageProduct(id: String? = null){
//        val fragment = ManageProductFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.fragmentContainer, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//
//        hideFab(false)
//    }

//    override fun goToManageProduct() {
//        val fragment = ManageProductFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.fragmentContainer, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//
//        view.hideFab(false)
//    }

//    override fun hideFab(isVisible: Boolean) {
//        if (isVisible) mBinding.fab.show() else mBinding.fab.hide()
//    }
}