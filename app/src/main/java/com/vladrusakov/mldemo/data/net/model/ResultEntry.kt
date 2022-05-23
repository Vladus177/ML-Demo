package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.ACCEPTS_MERCADOPAGO
import com.vladrusakov.mldemo.data.SearchConstants.ADDRESS
import com.vladrusakov.mldemo.data.SearchConstants.ATTRIBUTES
import com.vladrusakov.mldemo.data.SearchConstants.AVAILABLE_QUANTITY
import com.vladrusakov.mldemo.data.SearchConstants.BUYING_MODE
import com.vladrusakov.mldemo.data.SearchConstants.CATALOG_LISTING
import com.vladrusakov.mldemo.data.SearchConstants.CATALOG_PRODUCT_ID
import com.vladrusakov.mldemo.data.SearchConstants.CATEGORY_ID
import com.vladrusakov.mldemo.data.SearchConstants.CONDITION
import com.vladrusakov.mldemo.data.SearchConstants.CURRENCY_ID
import com.vladrusakov.mldemo.data.SearchConstants.ID
import com.vladrusakov.mldemo.data.SearchConstants.INSTALLMENTS
import com.vladrusakov.mldemo.data.SearchConstants.LISTING_TYPE_ID
import com.vladrusakov.mldemo.data.SearchConstants.OFFICIAL_STORE_ID
import com.vladrusakov.mldemo.data.SearchConstants.ORIGINAL_PRICE
import com.vladrusakov.mldemo.data.SearchConstants.PERMALINK
import com.vladrusakov.mldemo.data.SearchConstants.PRICE
import com.vladrusakov.mldemo.data.SearchConstants.SELLER
import com.vladrusakov.mldemo.data.SearchConstants.SELLER_ADDRESS
import com.vladrusakov.mldemo.data.SearchConstants.SHIPPING
import com.vladrusakov.mldemo.data.SearchConstants.SITE_ID
import com.vladrusakov.mldemo.data.SearchConstants.SOLD_QUANTITY
import com.vladrusakov.mldemo.data.SearchConstants.STOP_TIME
import com.vladrusakov.mldemo.data.SearchConstants.TAGS
import com.vladrusakov.mldemo.data.SearchConstants.THUMBNAIL
import com.vladrusakov.mldemo.data.SearchConstants.TITLE
import com.vladrusakov.mldemo.domain.model.ResultModel

data class ResultEntry(
    @SerializedName(ID) val id: String?,
    @SerializedName(SITE_ID) val siteId: String?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(SELLER) val seller: SellerEntry,
    @SerializedName(PRICE) val price: Double?,
    @SerializedName(CURRENCY_ID) val currencyId: String?,
    @SerializedName(AVAILABLE_QUANTITY) val availableQuantity: Long?,
    @SerializedName(SOLD_QUANTITY) val soldQuantity: Long?,
    @SerializedName(BUYING_MODE) val buyingMode: String?,
    @SerializedName(LISTING_TYPE_ID) val listingTypeId: String?,
    @SerializedName(STOP_TIME) val stopTime: String?,
    @SerializedName(CONDITION) val condition: String?,
    @SerializedName(PERMALINK) val permalink: String?,
    @SerializedName(THUMBNAIL) val thumbnail: String?,
    @SerializedName(ACCEPTS_MERCADOPAGO) val acceptsMercadopago: Boolean?,
    @SerializedName(INSTALLMENTS) val installments: InstallmentEntry,
    @SerializedName(ADDRESS) val address: AddressEntry,
    @SerializedName(SHIPPING) val shipping: ShippingEntry,
    @SerializedName(SELLER_ADDRESS) val sellerAddress: SellerAddressEntry,
    @SerializedName(ATTRIBUTES) val attributes: List<AttributeEntry>?,
    @SerializedName(ORIGINAL_PRICE) val originalPrice: Double?,
    @SerializedName(CATEGORY_ID) val categoryId: String?,
    @SerializedName(OFFICIAL_STORE_ID) val officialStoreId: Long?,
    @SerializedName(CATALOG_PRODUCT_ID) val catalogProductId: String?,
    @SerializedName(TAGS) val tags: List<String>?,
    @SerializedName(CATALOG_LISTING) val catalogListing: Boolean?
)

fun ResultEntry.toDomainModel(): ResultModel = ResultModel(
    id = id.orEmpty(),
    siteId = siteId.orEmpty(),
    title = title.orEmpty(),
    seller = seller.toDomainModel(),
    price = price ?: -1.0,
    currencyId = currencyId.orEmpty(),
    availableQuantity = availableQuantity ?: -1L,
    soldQuantity = soldQuantity ?: -1L,
    buyingMode = buyingMode.orEmpty(),
    listingTypeId = listingTypeId.orEmpty(),
    stopTime = stopTime.orEmpty(),
    condition = condition.orEmpty(),
    permalink = permalink.orEmpty(),
    thumbnail = thumbnail.orEmpty(),
    acceptsMercadopago = acceptsMercadopago ?: false,
    installments = installments.toDomainModel(),
    address = address.toDomainModel(),
    shipping = shipping.toDomainModel(),
    sellerAddress = sellerAddress.toDomainModel(),
    attributes = attributes?.map { it.toDomainModel() } ?: emptyList(),
    originalPrice = originalPrice ?: -1.0,
    categoryId = categoryId.orEmpty(),
    officialStoreId = officialStoreId ?: -1L,
    catalogProductId = catalogProductId.orEmpty(),
    tags = tags ?: emptyList(),
    catalogListing = catalogListing ?: false
)
