package com.vladrusakov.mldemo.util

import com.vladrusakov.mldemo.data.local.model.LastSearchEntity
import com.vladrusakov.mldemo.data.net.model.*
import com.vladrusakov.mldemo.domain.model.*

object SearchValuesFactory {
    const val QUERY = "Moto G7"
    const val QUERY_FORMATTED = "Moto%20G7"

    fun makeSearchResponseEntry(): SearchResponseEntry = SearchResponseEntry(
        siteId = "MLA",
        query = "Moto G7",
        paging = makePagingEntry(),
        results = makeResultsEntry()
    )

    fun makePagingEntry(): PagingEntry = PagingEntry(
        total = 916,
        offset = 0,
        limit = 50,
        primaryResults = 916
    )

    fun makeResultsEntry(): List<ResultEntry> {
        val entry = ResultEntry(
            id = "MLA810645375",
            siteId = "MLA",
            title = "Motorola G7 Plus 64 Gb",
            seller = makeSellerEntry(),
            price = 17999.0,
            currencyId = "ARS",
            availableQuantity = 100,
            soldQuantity = 0,
            buyingMode = "buy_it_now",
            listingTypeId = "gold_special",
            stopTime = "",
            condition = "new",
            permalink = "https://www.mercadolibre.com.ar/p/MLA9452524",
            thumbnail = "http://mla-s2-p.mlstatic.com/795558-MLA31003306206_062019-I.jpg",
            acceptsMercadopago = true,
            installments = makeInstallmentsEntry(),
            address = makeAddressEntry(),
            shipping = makeShippingEntry(),
            sellerAddress = makeSellerAddressEntry(),
            attributes = emptyList(),
            originalPrice = 20000.0,
            categoryId = "MLA1055",
            officialStoreId = 229,
            catalogProductId = "MLA9452524",
            tags = emptyList(),
            catalogListing = true
        )
        return listOf(entry)
    }

    fun makeSellerAddressEntry(): SellerAddressEntry = SellerAddressEntry(
        country = makeCountryEntry(),
        state = makeStateEntry(),
        city = makeCityEntry(),
        latitude = "",
        longitude = ""
    )

    fun makeStateEntry(): StateEntry = StateEntry(
        id = "AR-C",
        name = "Capital Federal"
    )

    fun makeCityEntry(): CityEntry = CityEntry(
        id = "TUxBQkJBTDMxMDZa",
        name = "Balvanera"
    )

    fun makeCountryEntry(): CountryEntry = CountryEntry(
        id = "AR",
        name = "Argentina"
    )

    fun makeShippingEntry(): ShippingEntry = ShippingEntry(
        freeShipping = true,
        mode = "custom",
        tags = emptyList(),
        logisticType = "custom",
        storePickUp = true
    )

    fun makeAddressEntry(): AddressEntry = AddressEntry(
        stateId = "AR-C",
        stateName = "Capital Federal",
        cityId = "TUxBQkJBTDMxMDZa",
        cityName = "Balvanera"
    )

    fun makeInstallmentsEntry(): InstallmentEntry = InstallmentEntry(
        quantity = 12,
        amount = 2456.1,
        rate = 63.77,
        currencyId = "ARS"
    )

    fun makeSellerEntry(): SellerEntry = SellerEntry(
        id = 12345678,
        powerSellerStatus = "platinum",
        carDealer = false,
        realEstateAgency = false,
        tags = emptyList()
    )


    fun makeSearchResponseModel(): SearchResponseModel = SearchResponseModel(
        siteId = "MLA",
        query = "Moto G7",
        paging = makePagingModel(),
        results = makeResultsModel()
    )

    fun makePagingModel(): PagingModel = PagingModel(
        total = 916,
        offset = 0,
        limit = 50,
        primaryResults = 916
    )

    fun makeResultsModel(): List<ResultModel> {
        val entry = ResultModel(
            id = "MLA810645375",
            siteId = "MLA",
            title = "Motorola G7 Plus 64 Gb",
            seller = makeSellerModel(),
            price = 17999.0,
            currencyId = "ARS",
            availableQuantity = 100,
            soldQuantity = 0,
            buyingMode = "buy_it_now",
            listingTypeId = "gold_special",
            stopTime = "",
            condition = "new",
            permalink = "https://www.mercadolibre.com.ar/p/MLA9452524",
            thumbnail = "http://mla-s2-p.mlstatic.com/795558-MLA31003306206_062019-I.jpg",
            acceptsMercadopago = true,
            installments = makeInstallmentsModel(),
            address = makeAddressModel(),
            shipping = makeShippingModel(),
            sellerAddress = makeSellerAddressModel(),
            attributes = emptyList(),
            originalPrice = 20000.0,
            categoryId = "MLA1055",
            officialStoreId = 229,
            catalogProductId = "MLA9452524",
            tags = emptyList(),
            catalogListing = true
        )
        return listOf(entry)
    }

    fun makeSellerAddressModel(): SellerAddressModel = SellerAddressModel(
        country = makeCountryModel(),
        state = makeStateModel(),
        city = makeCityModel(),
        latitude = "",
        longitude = ""
    )

    fun makeStateModel(): StateModel = StateModel(
        id = "AR-C",
        name = "Capital Federal"
    )

    fun makeCityModel(): CityModel = CityModel(
        id = "TUxBQkJBTDMxMDZa",
        name = "Balvanera"
    )

    fun makeCountryModel(): CountryModel = CountryModel(
        id = "AR",
        name = "Argentina"
    )

    fun makeShippingModel(): ShippingModel = ShippingModel(
        freeShipping = true,
        mode = "custom",
        tags = emptyList(),
        logisticType = "custom",
        storePickUp = true
    )

    fun makeAddressModel(): AddressModel = AddressModel(
        stateId = "AR-C",
        stateName = "Capital Federal",
        cityId = "TUxBQkJBTDMxMDZa",
        cityName = "Balvanera"
    )

    fun makeInstallmentsModel(): InstallmentModel = InstallmentModel(
        quantity = 12,
        amount = 2456.1,
        rate = 63.77,
        currencyId = "ARS"
    )

    fun makeSellerModel(): SellerModel = SellerModel(
        id = 12345678,
        powerSellerStatus = "platinum",
        carDealer = false,
        realEstateAgency = false,
        tags = emptyList()
    )

    fun makeLastSearchModel(): LastSearchModel = LastSearchModel(
        thumbnail = "MLA",
        description = "Moto G7",
        permalink = "url"
    )

    fun makeLastSearchEntity(): LastSearchEntity = LastSearchEntity(
        thumbnail = "MLA",
        description = "Moto G7",
        permalink = "url"
    )
}