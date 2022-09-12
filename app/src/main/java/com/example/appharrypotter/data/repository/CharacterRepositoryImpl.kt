package com.example.appharrypotter.data.repository

import com.example.appharrypotter.data.dataSource.CharacterRemoteDataSource
import com.example.appharrypotter.data.model.Character
import com.example.appharrypotter.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val remoteDataSource: CharacterRemoteDataSource) : CharacterRepository{

    override suspend fun getCharacterList(): List<Character>{
        return remoteDataSource.getListCharacters()
    }
}