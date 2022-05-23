package com.vladrusakov.mldemo.domain.model

data class SellerAddressModel(
    val country: CountryModel,
    val state: StateModel,
    val city: CityModel,
    val latitude: String,
    val longitude: String
)
