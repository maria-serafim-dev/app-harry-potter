package com.example.appharrypotter.domain.useCase

import com.example.appharrypotter.core.Result
import com.example.appharrypotter.domain.model.CharacterDomain
import com.example.appharrypotter.domain.repository.CharacterRepository

class CharacterListUseCaseImpl(private val repository: CharacterRepository) : CharacterListUseCase {

    override suspend fun invoke(): Result<List<CharacterDomain>> {
        return repository.getCharacterList()
    }
}