package com.vladrusakov.mldemo.domain.model

data class PagingModel(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val primaryResults: Int
)
