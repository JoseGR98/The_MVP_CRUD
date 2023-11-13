package com.luigidev.themvpcrud.features.manageproduct.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.luigidev.themvpcrud.R
import com.luigidev.themvpcrud.databinding.FragmentManageProductBinding
import com.luigidev.themvpcrud.features.home.domain.models.Product
import com.luigidev.themvpcrud.features.home.ui.MainActivity
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductView

class ManageProductFragment : Fragment(), IManageProductView {

    private lateinit var mBinding: FragmentManageProductBinding
    private var mActivity: MainActivity? = null

    private val presenter = ManageProductPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentManageProductBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity?.supportActionBar?.title = "Create a product"
        setHasOptionsMenu(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mActivity?.supportActionBar?.title = "Products"
        mActivity?.hideFab(true)
        setHasOptionsMenu(false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_save, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_save -> {

               val product = Product(
                    id = 1,
                    name = mBinding.etName.text.toString().trim(),
                    description = mBinding.etDescription.text.toString().trim(),
                    price = mBinding.etPrice.text.toString().trim().toInt()
                )
                presenter.saveProduct(requireContext(), product)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showUploadSuccess() {
        TODO("Not yet implemented")
    }

    override fun showUploadError() {
        TODO("Not yet implemented")
    }
}