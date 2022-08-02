package com.example.appharrypotter.repository

import com.example.appharrypotter.model.Character
import com.example.appharrypotter.network.HarryPotterApiService

class CharacterRepository(private val service: HarryPotterApiService) {

    suspend fun getCharacterList(): List<Character>{
        return service.getCharacter()
    }
}