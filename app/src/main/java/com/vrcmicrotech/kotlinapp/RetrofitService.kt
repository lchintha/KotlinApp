package com.vrcmicrotech.kotlinapp

import com.vrcmicrotech.kotlinapp.model.Repos
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String): Repos

}