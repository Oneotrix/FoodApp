package com.dipom.food.di

import android.app.Application
import android.content.Context
import com.dipom.food.FoodApp
import com.dipom.food.di.modules.MealsModule
import com.dipom.food.di.modules.PicassoModule
import com.dipom.food.di.component.MainActivityComponent
import com.dipom.food.di.component.MealsFragmentComponent
import com.dipom.food.di.modules.ContextModule
import com.dipom.food.di.modules.presenter.MealsPresenterModule
import com.dipom.food.mvp.presenter.MealsPresenter
import com.dipom.food.mvp.view.MealsContract
import com.dipom.food.network.api.MealsApi
import com.squareup.picasso.Picasso
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        MealsModule::class,
        PicassoModule::class,
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application)

        fun bind(): AppComponent
    }

    fun getMealsService(): MealsApi

    fun getPicasso(): Picasso

    fun mainActivityComponent(): MainActivityComponent

    fun inject(foodApp: FoodApp)
}