package com.vladrusakov.mldemo.domain.model

data class InstallmentModel(
    val quantity: Int,
    val amount: Double,
    val rate: Double,
    val currencyId: String
)
