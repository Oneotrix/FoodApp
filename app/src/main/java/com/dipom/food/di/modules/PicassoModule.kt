package com.dipom.food.di.modules

import android.content.Context
import com.dipom.food.di.annotation.ActivityContext
import com.dipom.food.di.annotation.ScopeApplication
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
@Module
class PicassoModule {
    @ScopeApplication
    @Provides
    fun picasso(
       @ActivityContext context: Context,
       okHttp3Downloader: OkHttp3Downloader
    ): Picasso {
        val picasso = Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()

        return picasso
    }

}