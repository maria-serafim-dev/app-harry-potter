package com.example.appharrypotter.data.dataSource

import com.example.appharrypotter.core.Result
import com.example.appharrypotter.data.model.CharacterResponse

interface CharacterRemoteDataSource {

    suspend fun getListCharacters() : Result<List<CharacterResponse>>
}