package com.dipom.food.di.component.activity

import com.dipom.food.MainActivity
import com.dipom.food.di.annotation.ScopeMainActivity
import dagger.Subcomponent
@ScopeMainActivity
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): MainActivityComponent
    }
}