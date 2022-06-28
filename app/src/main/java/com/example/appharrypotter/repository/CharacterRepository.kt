package com.example.appharrypotter.repository

import com.example.appharrypotter.model.Character
import com.example.appharrypotter.network.HarryPotterApiRetrofit

class CharacterRepository {

    suspend fun getCharacterList(): List<Character>{
        return HarryPotterApiRetrofit.retrofitService.getCharacter()
    }
}