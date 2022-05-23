package com.vladrusakov.mldemo.presentation.itemdetail

sealed class ItemDetailViewState(val isLoading: Boolean = false) {
    object Loading : ItemDetailViewState(isLoading = true)
    data class Error(val errorMessage: String) : ItemDetailViewState(isLoading = false)
    data class SuccessFetchItems(val list: String) : ItemDetailViewState(isLoading = false)
}
