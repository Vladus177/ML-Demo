package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants
import com.vladrusakov.mldemo.domain.model.StateModel

data class StateEntry(
    @SerializedName(SearchConstants.ID) val id: String?,
    @SerializedName(SearchConstants.NAME) val name: String?
)

fun StateEntry.toDomainModel(): StateModel = StateModel(
    id = id.orEmpty(),
    name = name.orEmpty()
)
