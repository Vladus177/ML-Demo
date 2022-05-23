package com.vladrusakov.mldemo.data.remote

import com.vladrusakov.mldemo.data.net.RetrofitSearchService
import com.vladrusakov.mldemo.data.net.model.SearchResponseEntry

class ItemsSearchRemoteSourceImpl(
    private val apiService: RetrofitSearchService
) : ItemsSearchRemoteSource {
    override suspend fun getProducts(query: String): SearchResponseEntry =
        apiService.getProducts(authorization = "", query = query)
}
