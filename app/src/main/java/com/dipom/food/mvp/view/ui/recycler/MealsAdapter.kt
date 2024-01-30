package com.dipom.food.mvp.view.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dipom.food.Comparator
import com.dipom.food.databinding.ItemMealBinding
import com.dipom.food.mvp.model.MealItemModel
import com.squareup.picasso.Picasso

class MealsAdapter(
    val picasso: Picasso
): ListAdapter<MealItemModel, MealViewHolder>(
    Comparator.mealsComparator
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return  MealViewHolder(
            binding = ItemMealBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            picasso = picasso
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}