package com.dipom.food.network.model

data class Ingredient(
    val text: String = "",
    val quantity: Int = 0,
    val measure: String = "",
    val food: String = "",
    val weight: Float = 0f,
    val foodCategory: String = "",
    val foodId: String = "",
    val image: String = "",
)
