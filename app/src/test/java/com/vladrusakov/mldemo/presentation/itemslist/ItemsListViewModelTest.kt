package com.vladrusakov.mldemo.presentation.itemslist

import com.vladrusakov.mldemo.domain.ItemsSearchUseCase
import com.vladrusakov.mldemo.util.SearchValuesFactory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class ItemsListViewModelTest {
    private val searchUseCase = mock(ItemsSearchUseCase::class.java)
    private val viewModel = ItemsListViewModel(searchUseCase)

    @Test
    fun `given ItemsListViewModel, when searchProducts, then returns data`() {
        runBlocking {
            val domainModel = SearchValuesFactory.makeSearchResponseModel()
            `when`(searchUseCase.searchProducts("test")).thenReturn(domainModel)

            val result = viewModel.searchProducts("test")

            Assertions.assertNotNull(result)
        }
    }
}
