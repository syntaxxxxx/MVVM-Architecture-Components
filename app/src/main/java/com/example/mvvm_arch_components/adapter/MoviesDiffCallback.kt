package com.example.mvvm_arch_components.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvm_arch_components.data.entity.Movies

class MoviesDiffCallback(private val oldItem: List<Movies>, private val newItem: List<Movies>) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem.get(oldItemPosition).id == newItem.get(newItemPosition).id

    @Suppress("USELESS_ELVIS")
    override fun getOldListSize(): Int = oldItem.size ?: 0

    @Suppress("USELESS_ELVIS")
    override fun getNewListSize(): Int = newItem.size ?: 0

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItemPosition == newItemPosition
}