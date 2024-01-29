package com.dipom.food.mvp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dipom.food.Comparator
import com.dipom.food.databinding.ItemMealBinding
import com.dipom.food.mvp.model.MealItemModel

class MealsAdapter: ListAdapter<MealItemModel,MealsAdapter.MealViewHolder>(
    Comparator.mealsComparator
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return  MealViewHolder(
            binding = ItemMealBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class MealViewHolder(
        binding: ItemMealBinding
    ) : ViewHolder(binding.root){

        fun bind(item: MealItemModel) {

        }
    }
}