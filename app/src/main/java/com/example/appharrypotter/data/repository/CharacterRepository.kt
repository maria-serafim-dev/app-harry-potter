package com.example.appharrypotter.data.repository

import com.example.appharrypotter.data.dataSource.CharacterRemoteDataSource
import com.example.appharrypotter.data.model.Character

class CharacterRepository(private val remoteDataSource: CharacterRemoteDataSource) {

    suspend fun getCharacterList(): List<Character>{
        return remoteDataSource.getListCharacters()
    }
}