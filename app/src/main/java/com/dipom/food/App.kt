package com.dipom.food

import android.app.Application
import com.dipom.food.di.DaggerAppComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.create()

    }

}