package com.vladrusakov.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.vladrusakov.ui.R

class LoadingView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttribute: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttribute) {
    init {
        View.inflate(context, R.layout.view_loading, this)
    }
}