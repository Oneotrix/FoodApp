package com.dipom.food.network.model

data class RecipeNetModel(
    val from: Int,
    val to: Int,
    val count: Int,
    val _links: Link? = null,
    val hits: List<Hit>? = null
){



}
