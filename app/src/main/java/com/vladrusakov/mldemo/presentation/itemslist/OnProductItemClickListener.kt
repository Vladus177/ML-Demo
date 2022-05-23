package com.vladrusakov.mldemo.presentation.itemslist

import com.vladrusakov.mldemo.presentation.model.Result

interface OnProductItemClickListener {
    fun productClick(product: Result)
}
