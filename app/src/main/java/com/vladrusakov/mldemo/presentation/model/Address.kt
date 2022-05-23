package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.AddressModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Address(
    val stateId: String,
    val stateName: String,
    val cityId: String,
    val cityName: String
) : Parcelable

fun AddressModel.toUiModel(): Address = Address(
    stateId = stateId,
    stateName = stateName,
    cityId = cityId,
    cityName = cityName
)
