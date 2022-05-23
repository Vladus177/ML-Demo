package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants
import com.vladrusakov.mldemo.domain.model.CityModel

data class CityEntry(
    @SerializedName(SearchConstants.ID) val id: String?,
    @SerializedName(SearchConstants.NAME) val name: String?
)

fun CityEntry.toDomainModel(): CityModel = CityModel(
    id = id.orEmpty(),
    name = name.orEmpty()
)
