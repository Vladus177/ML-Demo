package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.PagingModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Paging(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val primaryResults: Int
) : Parcelable

fun PagingModel.toUiModel(): Paging = Paging(
    total = total,
    offset = offset,
    limit = limit,
    primaryResults = primaryResults
)
