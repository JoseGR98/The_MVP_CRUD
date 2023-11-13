package com.luigidev.themvpcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luigidev.themvpcrud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.fab.setOnClickListener{
           goToManageProduct()
        }
    }

    private fun goToManageProduct(id: String? = null){
        val fragment = ManageProductFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        hideFab(false)
    }

    override fun hideFab(isVisible: Boolean) {
        if (isVisible) mBinding.fab.show() else mBinding.fab.hide()
    }
}