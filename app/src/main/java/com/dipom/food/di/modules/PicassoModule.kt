package com.dipom.food.di.modules

import android.content.Context
import com.dipom.food.di.annotation.ActivityContext
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [OkHttpClientModule::class, ContextModule::class])
class PicassoModule {

    @Provides
    fun picasso(
        okHttp3Downloader: OkHttp3Downloader,
        @ActivityContext context: Context): Picasso {
            return Picasso
                    .Builder(context)
                        .downloader(okHttp3Downloader)
                        .build()
    }

    @Provides
    fun okHttp3Downloader(
        okHttpClient: OkHttpClient
    ): OkHttp3Downloader {
        return  OkHttp3Downloader(okHttpClient)
    }

}