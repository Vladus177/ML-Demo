package com.vladrusakov.mldemo.data.local

import com.vladrusakov.common.datastore.PreferencesDataStore
import com.vladrusakov.mldemo.data.DataStoreKeys.PRODUCT_DESCRIPTION
import com.vladrusakov.mldemo.data.DataStoreKeys.THUMBNAIL
import com.vladrusakov.mldemo.data.DataStoreKeys.PERMALINK
import com.vladrusakov.mldemo.data.local.model.LastSearchEntity
import kotlinx.coroutines.flow.first


class ItemsSearchLocalSourceImpl(private val dataStore: PreferencesDataStore) :
    ItemsSearchLocalSource {
    override suspend fun getLastSearchProduct(): LastSearchEntity {
        val thumbnail = dataStore.fetchString(THUMBNAIL, "").first().orEmpty()
        val permalink = dataStore.fetchString(PERMALINK, "").first().orEmpty()
        val description = dataStore.fetchString(PRODUCT_DESCRIPTION, "").first().orEmpty()
        return LastSearchEntity(
            permalink = permalink,
            description = description,
            thumbnail = thumbnail
        )
    }

    override suspend fun storeLastSearchProductId(
        thumbnail: String,
        permalink: String,
        description: String
    ) {
        dataStore.apply {
            save(THUMBNAIL, thumbnail)
            save(PRODUCT_DESCRIPTION, description)
            save(PERMALINK, permalink)
        }
    }
}
