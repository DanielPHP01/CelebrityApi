package com.example.celebrityapi.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    fun create(): ApiService {
        val retrofit = Retrofit.Builder().baseUrl("https://celebrity-by-api-ninjas.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create()).build()

        return retrofit.create(ApiService::class.java)
    }
}