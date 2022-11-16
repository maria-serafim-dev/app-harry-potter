package com.example.appharrypotter.domain.repository

import com.example.appharrypotter.core.Result
import com.example.appharrypotter.domain.model.CharacterDomain

interface CharacterRepository {
    suspend fun getCharacterList(): Result<List<CharacterDomain>>
}