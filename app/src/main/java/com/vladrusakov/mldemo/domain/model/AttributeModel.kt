package com.vladrusakov.mldemo.domain.model

data class AttributeModel(
    val id: String,
    val name: String,
    val valueId: String,
    val valueName: String,
    val attributeGroupId: String,
    val attributeGroupName: String,
    val source: Long
)
