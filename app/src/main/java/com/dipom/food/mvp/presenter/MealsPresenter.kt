package com.dipom.food.mvp.presenter

import com.dipom.food.mvp.model.MealItemModel
import com.dipom.food.mvp.view.MealsContract
import com.dipom.food.network.api.MealsApi
import com.dipom.food.network.model.RecipeNetModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MealsPresenter(
    private val fragment: MealsContract.View
): MealsContract.Presenter {
    override fun mealsRequest(mealsService: MealsApi) {
        val call = mealsService.getRecipes()

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

                fragment.populateMeals(list)
            }

            override fun onFailure(call: Call<RecipeNetModel>, t: Throwable) {
                Timber.e(t)
            }

        })
    }
}