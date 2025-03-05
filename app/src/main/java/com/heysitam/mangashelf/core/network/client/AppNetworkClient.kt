package com.heysitam.mangashelf.core.network.client

import com.heysitam.mangashelf.core.network.baseurl.AppBaseUrl
import com.heysitam.mangashelf.core.network.service.AppApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppNetworkClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    val api: AppApiService by lazy {
        Retrofit.Builder()
            .baseUrl(AppBaseUrl.url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppApiService::class.java)
    }
}