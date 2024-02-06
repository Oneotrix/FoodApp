package com.dipom.food

import android.app.Application
import com.dipom.food.di.component.app.AppComponent
import com.dipom.food.di.component.app.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this@App)
            .build()

    }
    companion object {
        lateinit var appComponent: AppComponent
    }

}