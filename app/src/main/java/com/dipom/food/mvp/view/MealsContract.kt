package com.dipom.food.mvp.view

import com.dipom.food.mvp.model.MealItemModel
import com.dipom.food.network.api.MealsApi

interface MealsContract {

    interface View {
        fun populateMeals(list: List<MealItemModel>)
    }

    interface Presenter {
        fun mealsRequest(mealsService: MealsApi)
    }

}