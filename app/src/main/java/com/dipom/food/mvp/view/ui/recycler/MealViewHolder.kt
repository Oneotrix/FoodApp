package com.dipom.food.mvp.view.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.dipom.food.databinding.ItemMealBinding
import com.dipom.food.mvp.model.MealItemModel
import com.squareup.picasso.Picasso

class MealViewHolder(
    val binding: ItemMealBinding,
    val picasso: Picasso
) : RecyclerView.ViewHolder(binding.root){

    fun bind(item: MealItemModel) {
        binding.tvMealName.text = item.name
        picasso.load(item.img).into(binding.image)
    }
}