package com.db2testapp.di

import com.db2testapp.BuildConfig
import com.db2testapp.data.network.CustomHttpLogging
import com.db2testapp.data.network.NbuApiInterface
import com.db2testapp.data.network.PbApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor(CustomHttpLogging()).apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Singleton
    @Provides
    fun providePbApiInterface(client: OkHttpClient): PbApiInterface = Retrofit.Builder()
            .baseUrl(BuildConfig.PB_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PbApiInterface::class.java)

    @Singleton
    @Provides
    fun provideNbuApiInterface(client: OkHttpClient): NbuApiInterface  = Retrofit.Builder()
        .baseUrl(BuildConfig.NBU_BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NbuApiInterface::class.java)
}