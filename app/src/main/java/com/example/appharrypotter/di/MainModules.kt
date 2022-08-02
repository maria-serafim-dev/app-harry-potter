package com.example.appharrypotter.di

import com.example.appharrypotter.adapter.CharacterListAdapter
import com.example.appharrypotter.repository.CharacterRepository
import com.example.appharrypotter.viewModel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModules = module {
    single {
        CharacterRepository(service = get())
    }
    viewModel {
        CharacterViewModel(repository = get())
    }
    single {
        CharacterListAdapter()
    }
}
