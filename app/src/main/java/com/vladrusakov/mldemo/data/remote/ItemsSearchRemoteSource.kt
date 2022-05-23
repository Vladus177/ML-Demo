package com.vladrusakov.mldemo.data.remote

import com.vladrusakov.mldemo.data.net.model.SearchResponseEntry

interface ItemsSearchRemoteSource {
    suspend fun getProducts(query: String): SearchResponseEntry
}
