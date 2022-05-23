package com.vladrusakov.base.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<D>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun onBind(item: D)
}