package com.example.appharrypotter.network

import com.example.appharrypotter.model.Character
import retrofit2.http.GET

interface HarryPotterApiService {

    @GET("api/characters")
    suspend fun getCharacter() : List<Character>
}