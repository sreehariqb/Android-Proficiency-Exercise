package com.example.softvisiontestapp.data.network

import com.example.softvisiontestapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object RetrofitClientInstance {
    val retrofitInstance: Retrofit
        get() {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    private val client: OkHttpClient
        get() {
            val okHttpClientBuilder = OkHttpClient.Builder()
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return okHttpClientBuilder
                .readTimeout(
                    3,
                    TimeUnit.MINUTES
                )
                .connectTimeout(
                    3,
                    TimeUnit.MINUTES
                )
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }
}
