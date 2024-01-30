package com.dipom.food.network.model

data class DigestItem(
    val label: String = "",
    val tag: String = "",
    val schemaOrgTag: String = "",
    val total: Float = 0f,
    val hasRDI: Boolean = true,
    val daily: Float = 0f,
    val unit: String = "",
)
