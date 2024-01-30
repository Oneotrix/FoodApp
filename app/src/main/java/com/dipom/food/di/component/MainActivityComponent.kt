package com.dipom.food.di.component

import com.dipom.food.di.annotation.scope.ActivityScope
import dagger.Subcomponent

@Subcomponent
@ActivityScope
interface MainActivityComponent {

    fun mealsFragmentComponent(): MealsFragmentComponent
}