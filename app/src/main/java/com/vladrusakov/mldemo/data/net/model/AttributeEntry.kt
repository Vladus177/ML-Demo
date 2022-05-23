package com.vladrusakov.mldemo.data.net.model

import com.google.gson.annotations.SerializedName
import com.vladrusakov.mldemo.data.SearchConstants.ATTRIBUTE_GROUP_ID
import com.vladrusakov.mldemo.data.SearchConstants.ATTRIBUTE_GROUP_NAME
import com.vladrusakov.mldemo.data.SearchConstants.ID
import com.vladrusakov.mldemo.data.SearchConstants.NAME
import com.vladrusakov.mldemo.data.SearchConstants.SOURCE
import com.vladrusakov.mldemo.data.SearchConstants.VALUE_ID
import com.vladrusakov.mldemo.data.SearchConstants.VALUE_NAME
import com.vladrusakov.mldemo.data.SearchConstants.VALUE_STRUCT
import com.vladrusakov.mldemo.domain.model.AttributeModel

data class AttributeEntry(
    @SerializedName(ID) val id: String?,
    @SerializedName(NAME) val name: String?,
    @SerializedName(VALUE_ID) val valueId: String?,
    @SerializedName(VALUE_NAME) val valueName: String?,
    @SerializedName(ATTRIBUTE_GROUP_ID) val attributeGroupId: String?,
    @SerializedName(ATTRIBUTE_GROUP_NAME) val attributeGroupName: String?,
    @SerializedName(SOURCE) val source: Long?
)

fun AttributeEntry.toDomainModel(): AttributeModel = AttributeModel(
    id = id.orEmpty(),
    name = name.orEmpty(),
    valueId = valueId.orEmpty(),
    valueName = valueName.orEmpty(),
    attributeGroupId = attributeGroupId.orEmpty(),
    attributeGroupName = attributeGroupName.orEmpty(),
    source = source ?: -1
)
