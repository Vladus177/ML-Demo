package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.SellerAddressModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class SellerAddress(
    val country: Country,
    val state: State,
    val city: City,
    val latitude: String,
    val longitude: String
) : Parcelable

fun SellerAddressModel.toUiModel(): SellerAddress = SellerAddress(
    country = country.toUiModel(),
    state = state.toUiModel(),
    city = city.toUiModel(),
    latitude = latitude,
    longitude = longitude
)
