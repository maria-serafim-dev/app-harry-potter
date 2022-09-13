package com.example.appharrypotter.domain.repository

import com.example.appharrypotter.core.Result
import com.example.appharrypotter.data.model.Character

interface CharacterRepository {
    suspend fun getCharacterList(): Result<List<Character>>
}