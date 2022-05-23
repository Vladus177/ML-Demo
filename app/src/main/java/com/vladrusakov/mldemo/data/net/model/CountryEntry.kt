package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.ID
import com.vladrusakov.mldemo.data.SearchConstants.NAME
import com.vladrusakov.mldemo.domain.model.CountryModel

data class CountryEntry(
    @SerializedName(ID) val id: String?,
    @SerializedName(NAME) val name: String?
)

fun CountryEntry.toDomainModel(): CountryModel = CountryModel(
    id = id.orEmpty(),
    name = name.orEmpty()
)
