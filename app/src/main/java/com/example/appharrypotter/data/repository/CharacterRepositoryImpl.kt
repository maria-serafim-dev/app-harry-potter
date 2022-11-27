package com.example.appharrypotter.data.repository

import com.example.appharrypotter.core.Result
import com.example.appharrypotter.data.dataSource.CharacterLocalDataSource
import com.example.appharrypotter.data.dataSource.CharacterRemoteDataSource
import com.example.appharrypotter.data.model.mapper.toCharacterDomain
import com.example.appharrypotter.domain.model.CharacterDomain
import com.example.appharrypotter.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val remoteDataSource: CharacterRemoteDataSource, private val localDataSource: CharacterLocalDataSource) : CharacterRepository{

    override suspend fun getCharacterList(): Result<List<CharacterDomain>>{
        val characterList = remoteDataSource.getListCharacters()
        when(characterList) {
            is Result.Success -> {
                val character = Result.Success(characterList.list.map { character->
                    character.toCharacterDomain()
                })
                return character
            }
            is Result.Error -> {
                return  Result.Error(characterList.error)
            }
        }
    }
}