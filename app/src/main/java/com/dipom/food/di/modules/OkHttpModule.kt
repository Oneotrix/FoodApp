package com.dipom.food.di.modules

import android.content.Context
import com.dipom.food.di.annotation.ApplicationContext
import com.dipom.food.di.annotation.ScopeApplication
import com.squareup.picasso.OkHttp3Downloader
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

@Module
class OkHttpModule {
    @ScopeApplication
    @Provides
    fun okHttpClient(
        interceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .cache(cache)
            .build()
    }

    @Provides
    fun okHttp3Downloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }

    @Provides
    fun interceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor {
            message -> Timber.i(message)
        }

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }
    @Provides
    fun cache(
        file: File
    ): Cache {
        return Cache(file, 10 * 1000 * 1000)
    }
    @Provides
    fun file(
       @ApplicationContext context: Context
    ): File {
        return File(context.filesDir, "HttpsCache")
    }

}