package com.vladrusakov.mldemo.presentation.itemssearch

import com.vladrusakov.mldemo.domain.GetLastSearchProductUseCase
import com.vladrusakov.mldemo.util.SearchValuesFactory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class ItemsSearchViewModelTest {
    private val useCase = Mockito.mock(GetLastSearchProductUseCase::class.java)
    private val viewModel = ItemsSearchViewModel(useCase)

    @Test
    fun `given ItemsSearchViewModel, when getLastSearch, then returns data`() {
        runBlocking {
            val domainModel = SearchValuesFactory.makeLastSearchModel()

            Mockito.`when`(useCase.getLastSearch()).thenReturn(domainModel)

            val result = viewModel.getLastSearch()
            Assertions.assertNotNull(result)
        }
    }
}
