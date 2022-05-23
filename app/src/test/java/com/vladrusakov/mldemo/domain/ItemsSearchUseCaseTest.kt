package com.vladrusakov.mldemo.domain

import com.vladrusakov.mldemo.domain.repository.ItemsSearchRepository
import com.vladrusakov.mldemo.util.SearchValuesFactory
import com.vladrusakov.mldemo.util.SearchValuesFactory.QUERY
import com.vladrusakov.mldemo.util.SearchValuesFactory.QUERY_FORMATTED
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class ItemsSearchUseCaseTest {
    private val repository = Mockito.mock(ItemsSearchRepository::class.java)
    private var useCase = ItemsSearchUseCase(repository)

    @Test
    fun `given ItemsSearchUseCase, when call searchProducts, then return data`() {
        runBlocking {
            val domainModel = SearchValuesFactory.makeSearchResponseModel()
            Mockito.`when`(repository.getProducts(QUERY_FORMATTED)).thenReturn(domainModel)

            val result = useCase.searchProducts(QUERY)

            Mockito.verify(repository).getProducts(QUERY_FORMATTED)
            Assertions.assertNotNull(result)
            Assertions.assertEquals(domainModel, result)
        }
    }
}
