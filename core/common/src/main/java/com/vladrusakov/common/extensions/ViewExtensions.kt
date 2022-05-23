package com.vladrusakov.common.extensions

import android.view.View
import com.vladrusakov.common.utils.DebounceClickListener

fun View.setDebounceClickListener(onDebounceClick: (View) -> Unit) {
    val safeClickListener = DebounceClickListener {
        onDebounceClick(it)
    }
    setOnClickListener(safeClickListener)
}