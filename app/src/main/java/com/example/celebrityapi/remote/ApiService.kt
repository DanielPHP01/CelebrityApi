package com.example.celebrityapi.remote

import com.example.celebrityapi.remote.model.InfoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiService {
    @GET("/v1/celebrity")
    fun getInfo(
        @Query("name") name:String?,
        @Header("X-RapidAPI-Key") key:String = "41ed98c626msh68c4cff64a2d086p1ffe7bjsn9196f931643d",
        @Header("X-RapidAPI-Host") host:String = "celebrity-by-api-ninjas.p.rapidapi.com"
    ) : Call<InfoModel>
}