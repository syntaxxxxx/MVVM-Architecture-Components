package com.example.mvvm_arch_components.base.view

import androidx.recyclerview.widget.DiffUtil

class BaseDiffCallback<I>(private val oldList: List<I>, private val newList: List<I>) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItemPosition == newItemPosition

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItemPosition == newItemPosition

    @Suppress("USELESS_ELVIS")
    override fun getOldListSize(): Int = oldList.size ?: 0

    @Suppress("USELESS_ELVIS")
    override fun getNewListSize(): Int = newList.size ?: 0

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? =
        oldList[oldItemPosition] == newList[newItemPosition]
}