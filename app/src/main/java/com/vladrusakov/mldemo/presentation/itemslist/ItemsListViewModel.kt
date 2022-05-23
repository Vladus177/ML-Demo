package com.vladrusakov.mldemo.presentation.itemslist

import androidx.lifecycle.viewModelScope
import com.vladrusakov.base.viewmodel.BaseViewModel
import com.vladrusakov.common.exceptions.NoConnectionException
import com.vladrusakov.mldemo.domain.ItemsSearchUseCase
import com.vladrusakov.mldemo.presentation.itemslist.ItemsListViewState.*
import com.vladrusakov.mldemo.presentation.model.toUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsListViewModel(
    private val searchUseCase: ItemsSearchUseCase
) : BaseViewModel<ItemsListViewState>() {

    fun searchProducts(query: String) = viewModelScope.launch(Dispatchers.IO) {
        uiState.postValue(Loading)
        runCatching {
            searchUseCase.searchProducts(query.trim())
        }.onFailure {
            if (it is NoConnectionException) uiState.postValue(NetworkError) else uiState.postValue(
                GenericServiceError
            )
        }.onSuccess { products ->
            if (products.results.isEmpty()) uiState.postValue(Empty) else uiState.postValue(
                SuccessFetchProducts(products.toUiModel())
            )
        }
    }
}
