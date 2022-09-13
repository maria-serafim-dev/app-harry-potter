package com.example.appharrypotter.domain.useCase

import com.example.appharrypotter.core.Result
import com.example.appharrypotter.data.model.Character

interface CharacterListUseCase {
    suspend operator fun invoke() : Result<List<Character>>
}