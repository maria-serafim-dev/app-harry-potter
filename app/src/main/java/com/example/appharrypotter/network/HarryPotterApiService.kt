package com.example.appharrypotter.network

import com.example.appharrypotter.model.Personagem
import retrofit2.http.GET

interface HarryPotterApiService {

    @GET("api/characters")
    suspend fun getPersonagens() : List<Personagem>
}