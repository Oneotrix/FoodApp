package com.dipom.food.di.component

import com.dipom.food.di.annotation.scope.MealsFragmentScope
import com.dipom.food.mvp.view.ui.MealsFragment
import dagger.Subcomponent

@Subcomponent
@MealsFragmentScope
interface MealsFragmentComponent {

    fun inject(fragment: MealsFragment)

}