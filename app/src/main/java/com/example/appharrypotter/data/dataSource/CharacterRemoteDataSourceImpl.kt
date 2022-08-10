package com.example.appharrypotter.data.dataSource

import com.example.appharrypotter.data.model.Character
import com.example.appharrypotter.data.network.HarryPotterApiService

class CharacterRemoteDataSourceImpl (private val service : HarryPotterApiService) : CharacterRemoteDataSource{

    override suspend fun getListCharacters(): List<Character> {
        return service.getListCharacters()
    }
}