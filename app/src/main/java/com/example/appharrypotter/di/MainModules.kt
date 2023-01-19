package com.example.appharrypotter.di

import com.example.appharrypotter.data.dataSource.CharacterLocalDataSourceImpl
import com.example.appharrypotter.data.dataSource.CharacterRemoteDataSourceImpl
import com.example.appharrypotter.data.database.HarryPotterDatabase
import com.example.appharrypotter.data.repository.CharacterRepositoryImpl
import com.example.appharrypotter.domain.useCase.CharacterListUseCaseImpl
import com.example.appharrypotter.presentation.adapter.CharacterListAdapter
import com.example.appharrypotter.presentation.viewModel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModules = module {
    single {
        CharacterRepositoryImpl(remoteDataSource = get<CharacterRemoteDataSourceImpl>(), localDataSource = get<CharacterLocalDataSourceImpl>())
    }
    viewModel {
        CharacterViewModel(characterListUseCase = get<CharacterListUseCaseImpl>())
    }
    single {
        CharacterListAdapter()
    }
    single{
        CharacterRemoteDataSourceImpl(service = get(), get())
    }
    single{
        CharacterLocalDataSourceImpl(HarryPotterDatabase.getDatabase(get()).characterDao())
    }
    single {
        CharacterListUseCaseImpl(repository = get<CharacterRepositoryImpl>())
    }
}
