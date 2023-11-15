package com.luigidev.themvpcrud.features.manageproduct.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.luigidev.themvpcrud.R
import com.luigidev.themvpcrud.core.Product
import com.luigidev.themvpcrud.core.editable
import com.luigidev.themvpcrud.databinding.FragmentManageProductBinding
import com.luigidev.themvpcrud.features.home.ui.MainActivity
import com.luigidev.themvpcrud.features.manageproduct.domain.contracts.IManageProductView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)

        if (id != null && id != 0L) {//When clicking on "Edit" Product button
            isEditMode = true
            mActivity?.supportActionBar?.title = getString(R.string.sab_title_edit)
            mBinding.btnDelete.isVisible = true
            presenter.getProduct(requireContext(), id)
        } else {  //When clicking on New "+" FAB Product
            isEditMode = false
            mActivity?.supportActionBar?.title = getString(R.string.sab_title_create)
            mBinding.btnDelete.isVisible = false
        }

        mBinding.btnDelete.setOnClickListener {
            onDeleteButtonClick()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mActivity?.supportActionBar?.title = getString(R.string.sab_title_menu)
        mActivity?.hideFab(true)
        setHasOptionsMenu(false)
        (activity as MainActivity?)?.loadProducts()
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
                val name = mBinding.etProductName.text.toString().trim()
                val description = mBinding.etProductDescription.text.toString().trim()
                val price = mBinding.etProductPrice.text.toString().trim()

                if (!presenter.validateStrings(name, description, price)) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.fill_form),
                        Toast.LENGTH_SHORT
                    ).show()
                    false
                } else {
                    val newProduct = Product(
                        name = name,
                        description = description,
                        price = price.toInt()
                    )
                    if (isEditMode) { //U - Register update
                        presenter.modifyProduct(
                            context = requireContext(),
                            product = newProduct
                        )
                    } else { //C - Register creation
                        presenter.saveProduct(
                            context = requireContext(),
                            product = newProduct
                        )
                    }
                    true
                }
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showUploadSuccess() {
        Toast.makeText(requireContext(), getString(R.string.success), Toast.LENGTH_SHORT).show()
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    override fun showUploadError() {
        Toast.makeText(requireContext(), getString(R.string.error), Toast.LENGTH_SHORT).show()
    }

    override fun showEditMode(product: Product) {
        with(mBinding) {
            tvProductId.text = product.id.toString()
            etProductName.text = product.name.editable()
            etProductDescription.text = product.description.editable()
            etProductPrice.text = product.price.toString().editable()
        }
    }

    private fun onDeleteButtonClick() {
        presenter.eraseProduct(
            context = requireContext(),
            id = mBinding.tvProductId.text.toString().toLong()
        )
    }

}
