package com.vladrusakov.mldemo.domain.model

data class ShippingModel(
    val freeShipping: Boolean,
    val mode: String,
    val tags: List<String>,
    val logisticType: String,
    val storePickUp: Boolean
)
