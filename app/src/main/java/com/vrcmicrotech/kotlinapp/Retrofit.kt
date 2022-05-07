package com.vrcmicrotech.kotlinapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object{
        private const val BASE_URL = "https://api.github.com/search/"

        fun getRetrofitInstance(): Retrofit {
            return retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}