package com.vladrusakov.mldemo.presentation.itemssearch

import com.vladrusakov.mldemo.domain.model.LastSearch

sealed class ItemsSearchViewState(
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val isError: Boolean = false
) {
    object Loading : ItemsSearchViewState(isLoading = true, isEmpty = false, isError = false)
    object Empty : ItemsSearchViewState(isLoading = false, isEmpty = true, isError = false)
    data class Error(val errorMessage: String) :
        ItemsSearchViewState(isLoading = false, isEmpty = true, isError = false)

    data class SuccessFetchLastSearch(val lastSearch: LastSearch) :
        ItemsSearchViewState(isLoading = false, isEmpty = false, isError = false)
}
