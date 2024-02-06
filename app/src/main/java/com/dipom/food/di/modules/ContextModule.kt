package com.dipom.food.di.modules

import android.content.Context
import com.dipom.food.di.annotation.ActivityContext
import com.dipom.food.di.annotation.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ContextModule{
    @ApplicationContext
    @Provides
    fun contextApplication(context: Context): Context {
        return context.applicationContext
    }

    @ActivityContext
    @Provides
    fun contextActivity(context: Context): Context {
        return context
    }

}