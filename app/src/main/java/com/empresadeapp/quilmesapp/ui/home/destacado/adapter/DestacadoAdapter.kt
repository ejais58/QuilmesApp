package com.empresadeapp.quilmesapp.ui.home.destacado.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.empresadeapp.quilmesapp.core.BaseViewHolder
import com.empresadeapp.quilmesapp.data.model.Productos
import com.empresadeapp.quilmesapp.databinding.ItemProductoBinding

class DestacadoAdapter(private val productoList: List<Productos>): RecyclerView.Adapter<BaseViewHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DestacadoScreemViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is DestacadoScreemViewHolder -> holder.bind(productoList[position])
        }
    }

    override fun getItemCount(): Int =productoList.size

    private inner class DestacadoScreemViewHolder(
        val binding: ItemProductoBinding,
        val context: Context
    ): BaseViewHolder<Productos>(binding.root){
        override fun bind(item: Productos) {
            Glide.with(context).load(item.imagen).centerCrop().into(binding.imageItem)
            binding.productoItem.text = item.producto
            binding.precioItem.text = "$${item.precio}"
        }
    }
}