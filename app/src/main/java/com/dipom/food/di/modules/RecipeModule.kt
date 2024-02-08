package com.dipom.food.di.modules

import com.dipom.food.di.annotation.ScopeApplication
import com.dipom.food.network.api.ApiRecipe
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RecipeModule {
    @ScopeApplication
    @Provides
    fun getMealsService(retrofit: Retrofit): ApiRecipe {
        return retrofit.create(ApiRecipe::class.java)
    }

    @Provides
    fun retrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiRecipe.BASE_URL_RECIPES)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

        return retrofit
    }
    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun gson(): Gson {
        return GsonBuilder().create()
    }
}