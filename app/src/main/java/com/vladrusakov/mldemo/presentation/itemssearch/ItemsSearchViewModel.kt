package com.vladrusakov.mldemo.presentation.itemssearch

import androidx.lifecycle.viewModelScope
import com.vladrusakov.base.viewmodel.BaseViewModel
import com.vladrusakov.mldemo.domain.GetLastSearchProductUseCase
import com.vladrusakov.mldemo.domain.model.toUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsSearchViewModel(private val lastSearchProductUseCase: GetLastSearchProductUseCase) :
    BaseViewModel<ItemsSearchViewState>() {

    fun getLastSearch() = viewModelScope.launch(Dispatchers.IO) {
        uiState.postValue(ItemsSearchViewState.Loading)
        runCatching {
            lastSearchProductUseCase.getLastSearch()
        }.onFailure {
            uiState.postValue(ItemsSearchViewState.Error(""))
        }.onSuccess { response ->
            if (response.permalink.isEmpty()) {
                uiState.postValue(ItemsSearchViewState.Empty)
            } else {
                uiState.postValue(ItemsSearchViewState.SuccessFetchLastSearch(response.toUiModel()))
            }
        }
    }
}
