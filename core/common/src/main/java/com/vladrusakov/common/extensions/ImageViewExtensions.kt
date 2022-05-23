package com.vladrusakov.common.extensions

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun ImageView.setColorFilterResource(@ColorRes color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        colorFilter =
            BlendModeColorFilter(ContextCompat.getColor(context, color), BlendMode.SRC_OVER)
    } else {
        setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_OVER)
    }
}