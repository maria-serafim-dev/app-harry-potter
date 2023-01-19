package com.example.appharrypotter.data.dataSource

import com.example.appharrypotter.data.database.dao.CharacterDao
import com.example.appharrypotter.data.model.database.CharacterEntity

class CharacterLocalDataSourceImpl (private val characterDao: CharacterDao) : CharacterLocalDataSource{

    override suspend fun insertCharacters(characters: List<CharacterEntity>) {
        characterDao.insertCharacters(characters)
    }

    override suspend fun getAllCharacters(): List<CharacterEntity> {
        return characterDao.getAllCharacters()
    }

}