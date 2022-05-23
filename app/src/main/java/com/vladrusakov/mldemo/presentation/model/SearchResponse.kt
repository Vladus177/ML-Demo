package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.SearchResponseModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class SearchResponse(
    val siteId: String,
    val query: String,
    val paging: Paging,
    val results: List<Result>
) : Parcelable

fun SearchResponseModel.toUiModel(): SearchResponse = SearchResponse(
    siteId = siteId,
    query = query,
    paging = paging.toUiModel(),
    results = results.map { it.toUiModel() }
)
