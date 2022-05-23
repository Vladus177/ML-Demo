package com.vladrusakov.ui.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.vladrusakov.ui.databinding.ViewEmptyBinding

class EmptyView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttribute: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttribute) {

    private var binding: ViewEmptyBinding

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ViewEmptyBinding.inflate(inflater, this, true)
    }

    fun setAttrs(attrs: AttrsEmptyView) {
        binding.apply {
            tvErrorTitle.text = attrs.title
            tvErrorBody.text = attrs.message
            if (attrs.icon != null) {
                ivEmpty.setImageDrawable(attrs.icon)
            }
        }
    }
}

data class AttrsEmptyView(
    val title: String = "",
    val message: String = "",
    val primaryButtonName: String = "",
    val icon: Drawable? = null,
    val primaryButtonListener: () -> Unit = {}
)