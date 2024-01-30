package com.dipom.food.network.model

import com.dipom.food.network.model.enums.Diet
import com.dipom.food.network.model.enums.Health
import com.dipom.food.network.model.enums.ImageSize

data class Recipe(
    val uri: String? = null,
    val label: String? = null,
    val image: String? = null,
    val images: Map<ImageSize, Image>? = null,
    val source: String? = null,
    val url: String? = null,
    val shareAs: String? = null,
    val yield: Int = 0,
//    val dietLabels: Map<Int, Diet>? = null,
//    val healthLabels: Map<Int, Health>? = null,
//    val cautions: List<Any> = emptyList(),
//    val ingredientLines: Map<Int, String>? = null,
//    val ingredients: Map<Int, Ingredient>? = null,
//    val calories: Float = 0f,
//    val totalCO2Emissions: Float = 0f,
//    val co2EmissionsClass: String = "",
//    val totalWeight: Int = 0,
//    val totalTime: Int = 0,
//    val cuisineType: Map<Int, String>? = null,
//    val mealType: Map<Int,String>? = null,
//    val dishType: Map<Int, String>? = null,
//    val totalNutrients: Map<String, TotalNutrient> = mapOf(),
//    val totalDaily: Map<String, TotalNutrient> = mapOf(),
//    val digest: Map<Int, DigestItem> = mapOf(),
//    val tags: Map<Int, String> = mapOf(),
)