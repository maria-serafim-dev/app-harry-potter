package com.example.appharrypotter.data.network

import com.example.appharrypotter.data.model.Character
import retrofit2.http.GET

interface HarryPotterApiService {

    @GET("https://mocki.io/v1/cf9ec6a3-31f4-49e2-afa4-4b85d424c8de")
    suspend fun getCharacter() : List<Character>
}