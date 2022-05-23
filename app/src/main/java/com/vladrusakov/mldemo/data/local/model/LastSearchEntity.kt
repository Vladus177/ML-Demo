package com.vladrusakov.mldemo.data.local.model

import com.vladrusakov.mldemo.domain.model.LastSearchModel

data class LastSearchEntity(
    val thumbnail: String,
    val permalink: String,
    val description: String
)

fun LastSearchEntity.toDomainModel(): LastSearchModel = LastSearchModel(
    thumbnail = thumbnail,
    permalink = permalink,
    description = description
)
