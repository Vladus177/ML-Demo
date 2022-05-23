package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.PAGING
import com.vladrusakov.mldemo.data.SearchConstants.QUERY
import com.vladrusakov.mldemo.data.SearchConstants.RESULTS
import com.vladrusakov.mldemo.data.SearchConstants.SITE_ID
import com.vladrusakov.mldemo.domain.model.SearchResponseModel

data class SearchResponseEntry(
    @SerializedName(SITE_ID) val siteId: String?,
    @SerializedName(QUERY) val query: String?,
    @SerializedName(PAGING) val paging: PagingEntry,
    @SerializedName(RESULTS) val results: List<ResultEntry>?
)

fun SearchResponseEntry.toDomainModel(): SearchResponseModel = SearchResponseModel(
    siteId = siteId.orEmpty(),
    query = query.orEmpty(),
    paging = paging.toDomainModel(),
    results = results?.map { it.toDomainModel() } ?: emptyList(),
)
