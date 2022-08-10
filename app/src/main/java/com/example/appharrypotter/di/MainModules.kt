package com.example.appharrypotter.di

import com.example.appharrypotter.data.dataSource.CharacterRemoteDataSourceImpl
import com.example.appharrypotter.data.repository.CharacterRepository
import com.example.appharrypotter.domain.useCase.CharacterListUseCaseImpl
import com.example.appharrypotter.presentation.adapter.CharacterListAdapter
import com.example.appharrypotter.presentation.viewModel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModules = module {
    single {
        CharacterRepository(remoteDataSource = get<CharacterRemoteDataSourceImpl>())
    }
    viewModel {
        CharacterViewModel(characterListUseCase = get<CharacterListUseCaseImpl>())
    }
    single {
        CharacterListAdapter()
    }
    single{
        CharacterRemoteDataSourceImpl(service = get())
    }
    single {
        CharacterListUseCaseImpl(repository = get())
    }
}
