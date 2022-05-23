package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.CountryModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Country(
    val id: String,
    val name: String
) : Parcelable

fun CountryModel.toUiModel(): Country = Country(
    id = id,
    name = name
)
