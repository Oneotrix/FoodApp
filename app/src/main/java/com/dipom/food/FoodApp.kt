package com.dipom.food

import android.app.Application
import com.dipom.food.di.AppComponent

class FoodApp: Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

    }

}