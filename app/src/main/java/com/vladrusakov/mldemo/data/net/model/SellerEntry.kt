package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.CAR_DEALER
import com.vladrusakov.mldemo.data.SearchConstants.ID
import com.vladrusakov.mldemo.data.SearchConstants.POWER_SELLER_STATUS
import com.vladrusakov.mldemo.data.SearchConstants.REAL_ESTATE_AGENCY
import com.vladrusakov.mldemo.data.SearchConstants.TAGS
import com.vladrusakov.mldemo.domain.model.SellerModel

data class SellerEntry(
    @SerializedName(ID) val id: Int?,
    @SerializedName(POWER_SELLER_STATUS) val powerSellerStatus: String?,
    @SerializedName(CAR_DEALER) val carDealer: Boolean?,
    @SerializedName(REAL_ESTATE_AGENCY) val realEstateAgency: Boolean?,
    @SerializedName(TAGS) val tags: List<String>?
)

fun SellerEntry.toDomainModel(): SellerModel = SellerModel(
    id = id ?: -1,
    powerSellerStatus = powerSellerStatus.orEmpty(),
    carDealer = carDealer ?: false,
    realEstateAgency = realEstateAgency ?: false,
    tags = tags ?: emptyList(),
)
