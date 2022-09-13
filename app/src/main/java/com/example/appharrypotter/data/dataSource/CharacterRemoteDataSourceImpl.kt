package com.example.appharrypotter.data.dataSource

import android.content.Context
import com.example.appharrypotter.core.Result
import com.example.appharrypotter.core.util.checkConnection
import com.example.appharrypotter.data.model.Character
import com.example.appharrypotter.data.network.HarryPotterApiService

class CharacterRemoteDataSourceImpl(
    private val service: HarryPotterApiService,
    private val context: Context
) : CharacterRemoteDataSource {

    override suspend fun getListCharacters(): Result<List<Character>> {
        return if (checkConnection(context)) {
            try{
                Result.Success(service.getListCharacters())
            }catch(e: Exception){
                Result.Error("Não foi possível carregar os dados.")
            }
        } else {
            Result.Error("Não foi possível carregar os dados, verifique a conexão com a internet")
        }
    }
}