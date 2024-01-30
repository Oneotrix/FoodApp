package com.dipom.food.network.model

data class Link(
    val next: Next? = null,
    val self: Next? = null
) {
    data class Next(
        val title: String,
        val href: String,
    )
}