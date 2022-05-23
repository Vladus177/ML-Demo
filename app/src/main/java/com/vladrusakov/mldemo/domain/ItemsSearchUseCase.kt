package com.vladrusakov.mldemo.domain

import com.vladrusakov.common.extensions.formatSearchQuery
import com.vladrusakov.mldemo.domain.repository.ItemsSearchRepository

class ItemsSearchUseCase(private val repository: ItemsSearchRepository) {
    suspend fun searchProducts(query: String) = repository.getProducts(query.formatSearchQuery())
}
