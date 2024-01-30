package com.dipom.food.di.modules.presenter

import com.dipom.food.mvp.presenter.MealsPresenter
import com.dipom.food.mvp.view.MealsContract
import dagger.Module
import dagger.Provides

@Module
class MealsPresenterModule(
    private val view: MealsContract.View
) {
    @Provides
    fun getMealsFragment() : MealsContract.View  {
        return view
    }


}