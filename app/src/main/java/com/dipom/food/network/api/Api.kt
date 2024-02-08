package com.dipom.food.network.api
import com.dipom.food.network.model.RecipeNetModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("api/recipes/v2")
    fun getRecipes(
        @Query("type") type: String = "any",
        @Query("app_id") app_id: String = "679de2e3",
        @Query("app_key") app_key: String = "2c8c88fc151b3f2515e4dad1aa8a990c",
        @Query("mealType") mealType: String = "Dinner",
        @Query("random") random: String = "true"
    ) : Call<RecipeNetModel>



    companion object {
        const val BASE_URL_RECIPES = "https://api.edamam.com/"
    }

}