package com.empresadeapp.quilmesapp.ui.home.adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.empresadeapp.quilmesapp.core.BaseViewHolder
import com.empresadeapp.quilmesapp.data.model.Productos
import com.empresadeapp.quilmesapp.databinding.ItemProductosBinding


class GlobalAdapter(private val productoList: List<Productos>): RecyclerView.Adapter<BaseViewHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemProductosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GlobalScreemViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is GlobalScreemViewHolder -> holder.bind(productoList[position])
        }
    }

    override fun getItemCount() = productoList.size

    private inner class GlobalScreemViewHolder(
        val binding: ItemProductosBinding,
        val context: Context
    ): BaseViewHolder<Productos>(binding.root){
        override fun bind(item: Productos) {
            Glide.with(context).load(item.imagen).centerCrop().into(binding.imageProducto)
            binding.nombreProducto.text = item.producto
            binding.precioProducto.text = "$${item.precio}"
        }
    }
}