package com.vladrusakov.mldemo.domain

import com.vladrusakov.mldemo.domain.repository.ItemsSearchRepository

class GetLastSearchProductUseCase(private val repository: ItemsSearchRepository) {
    suspend fun getLastSearch() = repository.getLastSearch()
}
