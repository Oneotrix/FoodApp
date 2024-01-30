package com.dipom.food.di

import com.dipom.food.di.modules.MealsModule
import com.dipom.food.di.modules.PicassoModule
import com.dipom.food.network.api.MealsApi
import com.squareup.picasso.Picasso
import dagger.Component

@Component(
    modules = [
        MealsModule::class,
        PicassoModule::class,
    ]
)
interface AppComponent {

    fun getMealsService() : MealsApi

    fun getPicasso() : Picasso

}