package com.luigidev.themvpcrud.features.home.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.luigidev.themvpcrud.R
import com.luigidev.themvpcrud.core.Product
import com.luigidev.themvpcrud.databinding.ActivityMainBinding
import com.luigidev.themvpcrud.features.home.domain.contracts.IHomeView
import com.luigidev.themvpcrud.features.manageproduct.ui.ManageProductFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        loadProducts()
    }

    override fun showProducts(products: List<Product>) {
        mBinding.recyclerView.adapter = ProductsAdapter(products, this::goToEditProduct)
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun hideFab(isVisible: Boolean) {
        if (isVisible) mBinding.fab.show() else mBinding.fab.hide()
    }

    override fun goToManageProduct() {
        val fragment = ManageProductFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
        hideFab(false)
    }

    override fun goToEditProduct(id: Long) {
        val args = Bundle()
        args.putLong(getString(R.string.arg_id), id)

        val fragment = ManageProductFragment()
        fragment.arguments = args

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
        hideFab(false)
    }

    override fun loadProducts(){
        presenter.loadProducts(this)
    }

}
