package com.vladrusakov.ui.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.vladrusakov.ui.R
import com.vladrusakov.ui.databinding.ViewErrorBinding

class ErrorView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttribute: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttribute) {

    private var binding: ViewErrorBinding

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ViewErrorBinding.inflate(inflater, this, true)
    }

    init {
        View.inflate(context, R.layout.view_error, this)
    }

    fun setAttrs(attrs: AttrsErrorView) {
        binding.apply {
            tvErrorTitle.text = attrs.title
            tvErrorBody.text = attrs.message.also { tvErrorBody.isVisible = attrs.message.isNotEmpty() }
            if (attrs.icon != null) {
                ivError.setImageDrawable(attrs.icon)
            }
        }
    }
}

data class AttrsErrorView(
    val title: String = "",
    val message: String = "",
    val primaryButtonName: String = "",
    val secondaryButtonName: String = "",
    val icon: Drawable? = null,
    val primaryButtonListener: () -> Unit = {},
    val secondaryButtonListener: () -> Unit = {}
)