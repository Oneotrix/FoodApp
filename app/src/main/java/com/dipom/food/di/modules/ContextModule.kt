package com.dipom.food.di.modules

import android.content.Context
import com.dipom.food.di.annotation.ActivityContext
import com.dipom.food.di.annotation.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ContextModule(
    private val context: Context
) {
    @Provides
    @ApplicationContext
    fun applicationContext(): Context {
        return context.applicationContext
    }

    @Provides
    @ActivityContext
    fun activityContext(): Context {
        return context
    }

}