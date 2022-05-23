package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.common.extensions.formatDiscount
import com.vladrusakov.common.extensions.formatInstallments
import com.vladrusakov.common.extensions.formatPrice
import com.vladrusakov.common.extensions.validateAndConvertToString
import com.vladrusakov.mldemo.domain.model.ResultModel
import com.vladrusakov.mldemo.presentation.Constants.LISTING_TYPE_GOLD
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Result(
    val id: String,
    val siteId: String,
    val title: String,
    val seller: Seller,
    val price: String,
    val discount: String,
    val currencyId: String,
    val availableQuantity: String,
    val soldQuantity: String,
    val buyingMode: String,
    val listingTypeId: String,
    val stopTime: String,
    val condition: String,
    val permalink: String,
    val thumbnail: String,
    val acceptsMercadopago: Boolean,
    val isPromoted: Boolean,
    val installments: Installment,
    val formattedInstallments: String,
    val address: Address,
    val shipping: Shipping,
    val sellerAddress: SellerAddress,
    val attributes: List<Attribute>,
    val originalPrice: String,
    val categoryId: String,
    val officialStoreId: Long,
    val catalogProductId: String,
    val tags: List<String>,
    val catalogListing: Boolean
) : Parcelable

fun ResultModel.toUiModel(): Result = Result(
    id = id,
    siteId = siteId,
    title = title,
    seller = seller.toUiModel(),
    price = if (price < 0.0) price.validateAndConvertToString() else price.formatPrice(),
    discount = price.formatDiscount(originalPrice),
    currencyId = currencyId,
    availableQuantity = availableQuantity.validateAndConvertToString(),
    soldQuantity = soldQuantity.validateAndConvertToString(),
    buyingMode = buyingMode,
    listingTypeId = listingTypeId,
    stopTime = stopTime,
    condition = condition,
    permalink = permalink,
    thumbnail = thumbnail,
    acceptsMercadopago = acceptsMercadopago,
    isPromoted = listingTypeId == LISTING_TYPE_GOLD,
    installments = installments.toUiModel(),
    formattedInstallments = if (installments.quantity > 0) {
        installments.quantity.toString()
            .formatInstallments(installmensAmount = installments.amount.toString())
    } else "",
    address = address.toUiModel(),
    shipping = shipping.toUiModel(),
    sellerAddress = sellerAddress.toUiModel(),
    attributes = attributes.map { it.toUiModel() },
    originalPrice = originalPrice.validateAndConvertToString(),
    categoryId = categoryId,
    officialStoreId = officialStoreId,
    catalogProductId = catalogProductId,
    tags = tags,
    catalogListing = catalogListing
)
