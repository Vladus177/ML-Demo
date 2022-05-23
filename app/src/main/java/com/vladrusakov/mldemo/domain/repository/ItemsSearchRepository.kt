package com.vladrusakov.mldemo.domain.repository

import com.vladrusakov.mldemo.domain.model.LastSearchModel
import com.vladrusakov.mldemo.domain.model.SearchResponseModel

interface ItemsSearchRepository {
    suspend fun getProducts(query: String): SearchResponseModel
    suspend fun getLastSearch(): LastSearchModel
}
