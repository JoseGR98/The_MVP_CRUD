package com.luigidev.themvpcrud.features.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luigidev.themvpcrud.databinding.ItemProductBinding
import com.luigidev.themvpcrud.core.Product

class ProductsAdapter(private val products: List<Product>, private val onClick: (Long) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private lateinit var mBinding: ItemProductBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        mBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(mBinding.root)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = products[position]
        with(mBinding) {
//            root.setOnClickListener {
//                onClick(data.id.toString())
//            }
            btnEdit.setOnClickListener {
                onClick(data.id)
            }
            tvNameProduct.text = data.name
        }
    }

    override fun getItemCount(): Int = products.size

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}