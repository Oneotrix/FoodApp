package com.dipom.food.di.component.app

import android.content.Context
import com.dipom.food.di.annotation.ScopeApplication
import com.dipom.food.di.modules.ContextModule
import com.dipom.food.di.component.activity.MainActivityComponent
import com.dipom.food.di.component.fragment.MealsFragmentComponent
import com.dipom.food.di.modules.OkHttpModule
import com.dipom.food.di.modules.PicassoModule
import com.dipom.food.di.modules.RecipeModule
import com.squareup.picasso.Picasso
import dagger.BindsInstance
import dagger.Component
@ScopeApplication
@Component(
    modules = [
        AppModule::class,
        RecipeModule::class,
        OkHttpModule::class,
        PicassoModule::class,
        ContextModule::class]
)
interface AppComponent {

    fun mainActivityComponentBuilder(): MainActivityComponent.Builder
    fun mealsFragmentBuilder(): MealsFragmentComponent.Builder

    fun providePicasso(): Picasso

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }



}