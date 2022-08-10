package com.example.appharrypotter.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appharrypotter.data.model.Character
import com.example.appharrypotter.domain.useCase.CharacterListUseCase
import kotlinx.coroutines.launch

class CharacterViewModel(private val characterListUseCase : CharacterListUseCase): ViewModel() {

    private val _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>> get() = _characterList

    init {
        getCharacter()
    }

    private fun getCharacter(){
        viewModelScope.launch{
            _characterList.value = characterListUseCase()
        }
    }


}