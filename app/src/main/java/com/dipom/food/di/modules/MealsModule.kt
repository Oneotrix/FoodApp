package com.dipom.food.di.modules

import com.dipom.food.network.api.MealsApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpClientModule::class])
class MealsModule {

    @Provides
    fun mealsApi(retrofit: Retrofit): MealsApi {
        return retrofit.create(MealsApi::class.java)
    }

    @Provides
    fun retrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) : Retrofit {

        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(MealsApi.BASE_URL_RECIPES)
                .addConverterFactory(gsonConverterFactory)
                .build()

    }

    @Provides
    fun gsonConverterFactory(gson: Gson) : GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun gson() : Gson {
        return GsonBuilder().create()
    }
}