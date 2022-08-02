package com.example.appharrypotter.di


import com.example.appharrypotter.network.HarryPotterApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL =
    "https://hp-api.herokuapp.com/"

val retrofitModule = module {

    single{
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single{
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single{
        GsonConverterFactory.create()
    }

    single{
        createService(get(), get())
    }

}

private fun createService(client: OkHttpClient, factory: GsonConverterFactory) : HarryPotterApiService {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(factory)
        .build().create(HarryPotterApiService::class.java)
}