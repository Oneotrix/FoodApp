package com.dipom.food.mvp.meals

interface MealsContract {

    interface View {
        fun populateMeals(list: List<MealItemModel>)
    }

    interface Presenter {
        fun mealsRequest()
    }

}