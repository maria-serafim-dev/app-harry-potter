package com.example.appharrypotter.data.dataSource

import com.example.appharrypotter.data.model.database.CharacterEntity

interface CharacterLocalDataSource {

    suspend fun insertCharacters(characters: List<CharacterEntity>)

    suspend fun getAllCharacters() : List<CharacterEntity>

}