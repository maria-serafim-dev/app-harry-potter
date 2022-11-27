package com.example.appharrypotter.domain.useCase

import com.example.appharrypotter.data.model.Character
import com.example.appharrypotter.domain.repository.CharacterRepository

class CharacterListUseCaseImpl(private val repository: CharacterRepository) : CharacterListUseCase {

    override suspend fun invoke(): List<Character> {
        return repository.getCharacterList()
    }
}