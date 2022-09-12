package com.example.appharrypotter.domain.repository

import com.example.appharrypotter.data.model.Character

interface CharacterRepository {
    suspend fun getCharacterList(): List<Character>
}