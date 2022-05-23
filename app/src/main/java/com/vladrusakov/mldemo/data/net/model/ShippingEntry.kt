package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.FREE_SHIPPING
import com.vladrusakov.mldemo.data.SearchConstants.LOGISTIC_TYPE
import com.vladrusakov.mldemo.data.SearchConstants.MODE
import com.vladrusakov.mldemo.data.SearchConstants.STORE_PICK_UP
import com.vladrusakov.mldemo.data.SearchConstants.TAGS
import com.vladrusakov.mldemo.domain.model.ShippingModel

data class ShippingEntry(
    @SerializedName(FREE_SHIPPING) val freeShipping: Boolean?,
    @SerializedName(MODE) val mode: String?,
    @SerializedName(TAGS) val tags: List<String>?,
    @SerializedName(LOGISTIC_TYPE) val logisticType: String?,
    @SerializedName(STORE_PICK_UP) val storePickUp: Boolean?
)

fun ShippingEntry.toDomainModel(): ShippingModel = ShippingModel(
    freeShipping = freeShipping ?: false,
    mode = mode.orEmpty(),
    tags = tags ?: emptyList(),
    logisticType = logisticType.orEmpty(),
    storePickUp = storePickUp ?: false,
)
