package com.example.appharrypotter.data.repository

import com.example.appharrypotter.core.Result
import com.example.appharrypotter.data.dataSource.CharacterLocalDataSource
import com.example.appharrypotter.data.dataSource.CharacterRemoteDataSource
import com.example.appharrypotter.data.model.mapper.toCharacterDomain
import com.example.appharrypotter.data.model.mapper.toCharacterEntity
import com.example.appharrypotter.domain.model.CharacterDomain
import com.example.appharrypotter.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val remoteDataSource: CharacterRemoteDataSource, private val localDataSource: CharacterLocalDataSource) : CharacterRepository{

    override suspend fun getCharacterList(): Result<List<CharacterDomain>>{
        when(val characterListRemote = remoteDataSource.getListCharacters()) {
            is Result.Success -> {
                localDataSource.insertCharacters(characterListRemote.list.map { character ->
                    character.toCharacterEntity()
                })
                val characterListReturn =  characterListRemote.list.map { character ->
                    character.toCharacterDomain()
                }
                return Result.Success(characterListReturn)
            }
            is Result.Error -> {
                val characterListLocal = localDataSource.getAllCharacters()
                val characterListReturn =  characterListLocal.map { character ->
                    character.toCharacterDomain()
                }
                return Result.Success(characterListReturn)
            }
        }
    }
}