package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.CITY
import com.vladrusakov.mldemo.data.SearchConstants.COUNTRY
import com.vladrusakov.mldemo.data.SearchConstants.LATITUDE
import com.vladrusakov.mldemo.data.SearchConstants.LONGITUDE
import com.vladrusakov.mldemo.data.SearchConstants.STATE
import com.vladrusakov.mldemo.domain.model.SellerAddressModel

data class SellerAddressEntry(
    @SerializedName(COUNTRY) val country: CountryEntry,
    @SerializedName(STATE) val state: StateEntry,
    @SerializedName(CITY) val city: CityEntry,
    @SerializedName(LATITUDE) val latitude: String?,
    @SerializedName(LONGITUDE) val longitude: String?
)

fun SellerAddressEntry.toDomainModel(): SellerAddressModel = SellerAddressModel(
    country = country.toDomainModel(),
    state = state.toDomainModel(),
    city = city.toDomainModel(),
    latitude = latitude.orEmpty(),
    longitude = longitude.orEmpty(),
)
