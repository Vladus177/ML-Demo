package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.SellerModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Seller(
    val id: Int,
    val powerSellerStatus: String,
    val carDealer: Boolean,
    val realEstateAgency: Boolean,
    val tags: List<String>
) : Parcelable

fun SellerModel.toUiModel(): Seller = Seller(
    id = id,
    powerSellerStatus = powerSellerStatus,
    carDealer = carDealer,
    realEstateAgency = realEstateAgency,
    tags = tags
)
