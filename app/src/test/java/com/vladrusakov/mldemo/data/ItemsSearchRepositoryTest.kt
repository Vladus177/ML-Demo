package com.vladrusakov.mldemo.data

import com.vladrusakov.mldemo.data.local.ItemsSearchLocalSource
import com.vladrusakov.mldemo.data.remote.ItemsSearchRemoteSource
import org.mockito.Mockito.*
import com.vladrusakov.mldemo.util.SearchValuesFactory
import com.vladrusakov.mldemo.util.SearchValuesFactory.QUERY
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ItemsSearchRepositoryTest {

    var remote: ItemsSearchRemoteSource = mock(ItemsSearchRemoteSource::class.java)
    var local: ItemsSearchLocalSource = mock(ItemsSearchLocalSource::class.java)
    private val repository = ItemsSearchRepositoryImpl(remote, local)

    @Test
    fun `given ItemsSearchRepositoryImpl, when getProducts, then call ItemsSearchRemoteSource getProducts`() {
        runBlocking {
            val remoteEntry = SearchValuesFactory.makeSearchResponseEntry()
            `when`(remote.getProducts(QUERY)).thenReturn(remoteEntry)

            repository.getProducts(QUERY)

            verify(remote).getProducts(QUERY)
        }
    }

    @Test
    fun `given ItemsSearchRepositoryImpl, when getProducts, then returns data`() {
        runBlocking {
            val remoteEntry = SearchValuesFactory.makeSearchResponseEntry()
            val domainModel = SearchValuesFactory.makeSearchResponseModel()
            `when`(remote.getProducts(QUERY)).thenReturn(remoteEntry)

            val result = repository.getProducts(QUERY)

            assertNotNull(result)
            assertEquals(domainModel, result)
        }
    }

    @Test
    fun `given ItemsSearchRepositoryImpl, when getLastSearch, then call ItemsSearchLocalSource getLastSearchProduct`() {
        runBlocking {
            val entity = SearchValuesFactory.makeLastSearchEntity()
            `when`(local.getLastSearchProduct()).thenReturn(entity)

            repository.getLastSearch()

            verify(local).getLastSearchProduct()
        }
    }

    @Test
    fun `given ItemsSearchRepositoryImpl, when getLastSearch, then returns data`() {
        runBlocking {
            val entity = SearchValuesFactory.makeLastSearchEntity()
            val domainModel = SearchValuesFactory.makeLastSearchModel()
            `when`(local.getLastSearchProduct()).thenReturn(entity)

            val result = repository.getLastSearch()

            assertNotNull(result)
            assertEquals(domainModel, result)
        }
    }

    @Test
    fun `given ItemsSearchRepositoryImpl, when getProducts, then throw exception`() {
        runBlocking {
            val error = RuntimeException()

            `when`(remote.getProducts(QUERY)).thenThrow(error)

            assertThrows<Exception> { repository.getProducts(QUERY) }
        }
    }
}
