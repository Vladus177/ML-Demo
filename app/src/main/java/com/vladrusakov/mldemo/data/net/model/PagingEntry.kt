package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.LIMIT
import com.vladrusakov.mldemo.data.SearchConstants.TOTAL
import com.vladrusakov.mldemo.data.SearchConstants.OFFSET
import com.vladrusakov.mldemo.data.SearchConstants.PRIMARY_RESULT
import com.vladrusakov.mldemo.domain.model.PagingModel

data class PagingEntry(
    @SerializedName(TOTAL) val total: Int?,
    @SerializedName(OFFSET) val offset: Int?,
    @SerializedName(LIMIT) val limit: Int?,
    @SerializedName(PRIMARY_RESULT) val primaryResults: Int?
)

fun PagingEntry.toDomainModel(): PagingModel = PagingModel(
    total = total ?: 0,
    offset = offset ?: 0,
    limit = limit ?: 0,
    primaryResults = primaryResults ?: 0
)
