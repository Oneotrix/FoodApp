package com.dipom.food.mvp.meals

import com.dipom.food.network.api.ApiRecipe
import com.dipom.food.network.model.RecipeNetModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class MealsPresenter @Inject constructor(
    private val apiRecipe: ApiRecipe,
    private val view: MealsContract.View
) : MealsContract.Presenter {
    override fun mealsRequest() {
        val call: Call<RecipeNetModel> = apiRecipe.getRecipes()
        call.enqueue(object : Callback<RecipeNetModel> {
            override fun onResponse(
                call: Call<RecipeNetModel>,
                response: Response<RecipeNetModel>
            ) {
                val list = mutableListOf<MealItemModel>()
                response.body()?.hits?.forEach {
                    list.add(
                        MealItemModel(
                            img = it.recipe?.image,
                            name = it.recipe?.label,
                    )
                    )
                }

                view.populateMeals(list)
            }

            override fun onFailure(call: Call<RecipeNetModel>, t: Throwable) {
                Timber.e(t)
            }

        })
    }
}