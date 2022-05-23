package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.AMOUNT
import com.vladrusakov.mldemo.data.SearchConstants.CURRENCY_ID
import com.vladrusakov.mldemo.data.SearchConstants.QUANTITY
import com.vladrusakov.mldemo.data.SearchConstants.RATE
import com.vladrusakov.mldemo.domain.model.InstallmentModel

data class InstallmentEntry(
    @SerializedName(QUANTITY) val quantity: Int?,
    @SerializedName(AMOUNT) val amount: Double?,
    @SerializedName(RATE) val rate: Double?,
    @SerializedName(CURRENCY_ID) val currencyId: String?,
)

fun InstallmentEntry.toDomainModel(): InstallmentModel = InstallmentModel(
    quantity = quantity ?: -1,
    amount = amount ?: -1.0,
    rate = rate ?: -1.0,
    currencyId = currencyId.orEmpty()
)
