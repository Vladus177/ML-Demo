package com.vladrusakov.mldemo.domain.model

data class LastSearch(
    val thumbnail: String,
    val permalink: String,
    val description: String
)

fun LastSearchModel.toUiModel(): LastSearch = LastSearch(
    thumbnail = thumbnail,
    permalink = permalink,
    description = description
)
