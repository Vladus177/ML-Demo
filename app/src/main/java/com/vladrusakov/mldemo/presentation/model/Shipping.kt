package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.ShippingModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Shipping(
    val freeShipping: Boolean,
    val mode: String,
    val tags: List<String>,
    val logisticType: String,
    val storePickUp: Boolean
) : Parcelable

fun ShippingModel.toUiModel(): Shipping = Shipping(
    freeShipping = freeShipping,
    mode = mode,
    tags = tags,
    logisticType = logisticType,
    storePickUp = storePickUp
)
