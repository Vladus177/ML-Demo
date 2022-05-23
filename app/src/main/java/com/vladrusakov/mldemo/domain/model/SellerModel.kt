package com.vladrusakov.mldemo.domain.model

data class SellerModel(
    val id: Int,
    val powerSellerStatus: String,
    val carDealer: Boolean,
    val realEstateAgency: Boolean,
    val tags: List<String>
)
