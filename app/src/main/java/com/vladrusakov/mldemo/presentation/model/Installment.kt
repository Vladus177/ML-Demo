package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.common.extensions.validateAndConvertToString
import com.vladrusakov.mldemo.domain.model.InstallmentModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Installment(
    val quantity: String,
    val amount: String,
    val rate: String,
    val currencyId: String
) : Parcelable

fun InstallmentModel.toUiModel(): Installment = Installment(
    quantity = quantity.validateAndConvertToString(),
    amount = amount.validateAndConvertToString(),
    rate = rate.validateAndConvertToString(),
    currencyId = currencyId
)
