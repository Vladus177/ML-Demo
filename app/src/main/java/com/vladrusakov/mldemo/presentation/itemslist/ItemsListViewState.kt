package com.vladrusakov.mldemo.presentation.itemslist

import com.vladrusakov.mldemo.presentation.model.SearchResponse


sealed class ItemsListViewState(
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false,
    val isError: Boolean = false
) {
    object Loading : ItemsListViewState(isLoading = true, isEmpty = false, isError = false)

    object Empty : ItemsListViewState(isLoading = false, isEmpty = true, isError = false)

    object GenericServiceError :
        ItemsListViewState(isLoading = false, isEmpty = false, isError = true)

    object NetworkError : ItemsListViewState(isLoading = false, isEmpty = false, isError = true)

    data class SuccessFetchProducts(val searchResponse: SearchResponse) :
        ItemsListViewState(isLoading = false, isEmpty = false, isError = false)
}
