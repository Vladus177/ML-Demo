package com.vladrusakov.mldemo.presentation.itemslist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.vladrusakov.base.adapter.BaseAdapter
import com.vladrusakov.base.adapter.BaseViewHolder
import com.vladrusakov.common.extensions.asDrawable
import com.vladrusakov.common.extensions.load
import com.vladrusakov.common.extensions.setDebounceClickListener
import com.vladrusakov.mldemo.R
import com.vladrusakov.mldemo.databinding.ItemDetailBinding
import com.vladrusakov.mldemo.presentation.model.Result

class ItemsListAdapter(private val listener: OnProductItemClickListener) :
    BaseAdapter<Result, ItemsListAdapter.ViewHolder>() {

    private val items = mutableListOf<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    inner class ViewHolder(itemBinding: ItemDetailBinding) : BaseViewHolder<Result>(itemBinding) {
        private val title: TextView = itemBinding.tvProductTitle
        private val price: TextView = itemBinding.tvProductPrice
        private val discount: TextView = itemBinding.tvProductDiscount
        private val installments: TextView = itemBinding.tvProductInstallments
        private val attribute: TextView = itemBinding.tvProductFreeShipping
        private val promoted: TextView = itemBinding.tvProductPromoted
        private val image: ImageView = itemBinding.ivProduct
        private val imageFavorite: ImageView = itemBinding.ivFavorite
        private val rootLayout: ConstraintLayout = itemBinding.clRoot
        override fun onBind(item: Result) {
            title.text = item.title
            price.text = item.price
            discount.text = item.discount
            installments.isVisible = item.formattedInstallments.isNotEmpty()
                .also { installments.text = item.formattedInstallments }
            attribute.isVisible = item.shipping.freeShipping
            promoted.isVisible = item.isPromoted
            image.load(item.thumbnail)
            rootLayout.setDebounceClickListener { listener.productClick(item) }
            imageFavorite.setOnClickListener {
                // Just for demonstration purpose
                imageFavorite.setImageDrawable(R.drawable.ic_baseline_heart_24.asDrawable(it.context))
            }
        }
    }

    override fun setItems(newItems: List<Result>) {
        items.clear()
        items.addAll(newItems)
        super.setItems(newItems)
    }
}
