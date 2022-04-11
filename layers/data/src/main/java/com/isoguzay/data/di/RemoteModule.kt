package com.isoguzay.data.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.isoguzay.data.BuildConfig
import com.isoguzay.data.util.Constants
import com.isoguzay.data.remote.service.AppCallAdapterFactory
import com.isoguzay.data.remote.service.OpenSkyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit): OpenSkyApiService =
        retrofit.create(OpenSkyApiService::class.java)

    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        appCallAdapterFactory: AppCallAdapterFactory,
    ): Retrofit {
        val interceptorDebug = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)
            interceptorDebug.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(interceptorDebug)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.APP_BASE_URL)
            .addCallAdapterFactory(appCallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkhttpCache(@ApplicationContext context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun providesAppCallAdapterFactory(): AppCallAdapterFactory {
        return AppCallAdapterFactory()
    }

}