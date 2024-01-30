package com.dipom.food.di.component

import com.dipom.food.di.modules.presenter.MealsPresenterModule
import com.dipom.food.mvp.view.ui.MealsFragment
import dagger.Component

@Component(modules = [MealsPresenterModule::class])
interface PresenterComponent {
    fun inject(view: MealsFragment)

}