package com.munmundev.belajargit.data.database.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
//    private const val BASE_URL = "https://"
//    private const val BASE_URL = "https://192.168.1.21/makkode-magang/"
    private const val BASE_URL = "https://aplikasitugas17.000webhostapp.com/Sistem-Informasi-PT-Candid-Coco-Indonesia/"

    fun getRetrofit(): ApiService{
        val gson = GsonBuilder().create()
        val retrofit =Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(ApiService::class.java)
    }
}