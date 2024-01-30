package com.dipom.food.utils

import androidx.recyclerview.widget.DiffUtil
import com.dipom.food.mvp.model.MealItemModel

object Comparator {

    val mealsComparator = object: DiffUtil.ItemCallback<MealItemModel>() {
        override fun areItemsTheSame(oldItem: MealItemModel, newItem: MealItemModel): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: MealItemModel, newItem: MealItemModel): Boolean {
            return true
        }

    }
}