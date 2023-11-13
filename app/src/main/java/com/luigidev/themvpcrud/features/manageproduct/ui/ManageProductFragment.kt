package com.luigidev.themvpcrud.features.manageproduct.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.luigidev.themvpcrud.R
import com.luigidev.themvpcrud.databinding.FragmentManageProductBinding
import com.luigidev.themvpcrud.core.Product
import com.luigidev.themvpcrud.core.editable
import com.luigidev.themvpcrud.features.home.ui.MainActivity
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductView

class ManageProductFragment : Fragment(), IManageProductView {

    private lateinit var mBinding: FragmentManageProductBinding
    private var mActivity: MainActivity? = null
    private var isEditMode: Boolean = false

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
        val id = arguments?.getLong(getString(R.string.arg_id), 0L)
        Log.i("VIEW", "id as argument $id")
        if (id != null && id != 0L) {
            isEditMode = true
            Log.i("View", "Id in manage product $id")
            presenter.editProduct(requireContext(), id)
        } else {
            //Manage edit mode
        }

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
                if (isEditMode) {
                    //Manage the edit mode
                } else {
                    val product = Product(
                        id = 1,
                        name = mBinding.etName.text.toString().trim(),
                        description = mBinding.etDescription.text.toString().trim(),
                        price = mBinding.etPrice.text.toString().trim().toInt()
                    )
                    presenter.saveProduct(requireContext(), product)
                }
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showUploadSuccess() {
        Toast.makeText(requireContext(), "Product Saved", Toast.LENGTH_SHORT).show()
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    override fun showUploadError() {
        Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
    }

    override fun showEditMode(product: Product) {
        with(mBinding) {
            etName.text = product.name.editable()
            etDescription.text = product.description.editable()
            etPrice.text = product.price.toString().editable()
        }

    }

}