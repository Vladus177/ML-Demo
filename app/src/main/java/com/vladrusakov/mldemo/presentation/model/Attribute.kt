package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.AttributeModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Attribute(
    val id: String,
    val name: String,
    val valueId: String,
    val valueName: String,
    val attributeGroupId: String,
    val attributeGroupName: String,
    val source: Long
) : Parcelable

fun AttributeModel.toUiModel(): Attribute = Attribute(
    id = id,
    name = name,
    valueId = valueId,
    valueName = valueName,
    attributeGroupId = attributeGroupId,
    attributeGroupName = attributeGroupName,
    source = source,
)
