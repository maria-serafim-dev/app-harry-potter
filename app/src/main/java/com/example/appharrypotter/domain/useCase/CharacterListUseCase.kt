package com.example.appharrypotter.domain.useCase

import com.example.appharrypotter.core.Result
import com.example.appharrypotter.domain.model.CharacterDomain

interface CharacterListUseCase {
    suspend operator fun invoke() : Result<List<CharacterDomain>>
}