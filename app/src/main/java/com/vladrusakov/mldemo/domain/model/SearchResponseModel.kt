package com.vladrusakov.mldemo.domain.model

data class SearchResponseModel(
    val siteId: String,
    val query: String,
    val paging: PagingModel,
    val results: List<ResultModel>
)
