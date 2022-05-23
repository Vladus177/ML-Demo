package com.vladrusakov.mldemo.domain

import com.vladrusakov.mldemo.domain.repository.ItemsSearchRepository
import com.vladrusakov.mldemo.util.SearchValuesFactory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class GetLastSearchProductUseCaseTest {
    private val repository = Mockito.mock(ItemsSearchRepository::class.java)
    private var useCase = GetLastSearchProductUseCase(repository)

    @Test
    fun `given LastSearchProductUseCase, when call getLastSearch, then return data`() {
        runBlocking {
            val domainModel = SearchValuesFactory.makeLastSearchModel()
            Mockito.`when`(repository.getLastSearch()).thenReturn(domainModel)

            val result = useCase.getLastSearch()

            Mockito.verify(repository).getLastSearch()
            Assertions.assertNotNull(result)
            Assertions.assertEquals(domainModel, result)
        }
    }
}
