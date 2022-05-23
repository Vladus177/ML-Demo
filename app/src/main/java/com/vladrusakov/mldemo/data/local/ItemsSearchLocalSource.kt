package com.vladrusakov.mldemo.data.local

import com.vladrusakov.mldemo.data.local.model.LastSearchEntity

interface ItemsSearchLocalSource {
    suspend fun getLastSearchProduct(): LastSearchEntity
    suspend fun storeLastSearchProductId(thumbnail: String, permalink: String, description: String)
}
