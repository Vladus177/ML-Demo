package com.vladrusakov.mldemo.data

import com.vladrusakov.mldemo.data.local.ItemsSearchLocalSource
import com.vladrusakov.mldemo.data.local.model.toDomainModel
import com.vladrusakov.mldemo.data.net.model.toDomainModel
import com.vladrusakov.mldemo.data.remote.ItemsSearchRemoteSource
import com.vladrusakov.mldemo.domain.model.LastSearchModel
import com.vladrusakov.mldemo.domain.model.SearchResponseModel
import com.vladrusakov.mldemo.domain.repository.ItemsSearchRepository

class ItemsSearchRepositoryImpl(
    private val remoteDataSource: ItemsSearchRemoteSource,
    private val localDataSource: ItemsSearchLocalSource,
) : ItemsSearchRepository {

    override suspend fun getProducts(query: String): SearchResponseModel =
        remoteDataSource.getProducts(query).toDomainModel().also { response ->
            if (response.results.isNotEmpty()) {
                val product = response.results.first()
                localDataSource.storeLastSearchProductId(
                    permalink = product.permalink,
                    thumbnail = product.thumbnail,
                    description = product.title
                )
            }
        }

    override suspend fun getLastSearch(): LastSearchModel =
        localDataSource.getLastSearchProduct().toDomainModel()
}
