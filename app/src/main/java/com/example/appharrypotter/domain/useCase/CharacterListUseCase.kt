package com.example.appharrypotter.domain.useCase

import com.example.appharrypotter.data.model.Character

interface CharacterListUseCase {
    suspend operator fun invoke() : List<Character>
}