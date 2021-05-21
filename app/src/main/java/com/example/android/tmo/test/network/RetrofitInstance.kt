package com.example.android.tmo.test.network

import com.example.android.tmo.test.api.CatFactsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Create By Gouse Mohiddin
* Made by MJ Creative Works
*/class RetrofitInstance {
    companion object {
        private val retrofit by lazy {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl("https://cat-fact.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api by lazy {
            retrofit.create(CatFactsApi::class.java)
        }
    }
}