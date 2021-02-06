package com.db2testapp.data.network

import com.db2testapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BankApiClient {

    private var client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor(CustomHttpLogging()).apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    val pbApiClient: PbApiInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.PB_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(PbApiInterface::class.java)
    }

    val nbuApiClient: NbuApiInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.NBU_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(NbuApiInterface::class.java)
    }
}