package com.dipom.food.di.component.fragment

import com.dipom.food.di.annotation.ScopeMealsFragment
import com.dipom.food.mvp.meals.MealsContract
import com.dipom.food.mvp.meals.ui.MealsFragment
import dagger.BindsInstance
import dagger.Subcomponent
@ScopeMealsFragment
@Subcomponent
interface MealsFragmentComponent {

    fun inject(mealsFragment: MealsFragment)
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun view(view: MealsContract.View): Builder
        fun build(): MealsFragmentComponent
    }
}