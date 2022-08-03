package com.example.appharrypotter.data.repository

import com.example.appharrypotter.data.dataSource.CharacterRemoteDataSourceImpl
import com.example.appharrypotter.data.model.Character

class CharacterRepository(private val remoteDataSource: CharacterRemoteDataSourceImpl) {

    suspend fun getCharacterList(): List<Character>{
        return remoteDataSource.getListCharacters()
    }
}