package com.example.appharrypotter.data.repository

import com.example.appharrypotter.data.model.Character
import com.example.appharrypotter.data.network.HarryPotterApiService

class CharacterRepository(private val service: HarryPotterApiService) {

    suspend fun getCharacterList(): List<Character>{
        return service.getCharacter()
    }
}