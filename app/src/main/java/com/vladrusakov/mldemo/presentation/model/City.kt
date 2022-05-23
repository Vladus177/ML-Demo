package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.CityModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class City(
    val id: String,
    val name: String
) : Parcelable

fun CityModel.toUiModel(): City = City(
    id = id,
    name = name
)

