package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.CITY_ID
import com.vladrusakov.mldemo.data.SearchConstants.CITY_NAME
import com.vladrusakov.mldemo.data.SearchConstants.STATE_ID
import com.vladrusakov.mldemo.data.SearchConstants.STATE_NAME
import com.vladrusakov.mldemo.domain.model.AddressModel

data class AddressEntry(
    @SerializedName(STATE_ID) val stateId: String?,
    @SerializedName(STATE_NAME) val stateName: String?,
    @SerializedName(CITY_ID) val cityId: String?,
    @SerializedName(CITY_NAME) val cityName: String?
)

fun AddressEntry.toDomainModel(): AddressModel =
    AddressModel(
        stateId = stateId.orEmpty(),
        stateName = stateName.orEmpty(),
        cityId = cityId.orEmpty(),
        cityName = cityName.orEmpty()
    )
