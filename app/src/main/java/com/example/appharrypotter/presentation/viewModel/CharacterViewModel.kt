package com.example.appharrypotter.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appharrypotter.core.Result.Error
import com.example.appharrypotter.core.Result.Success
import com.example.appharrypotter.data.model.Character
import com.example.appharrypotter.domain.useCase.CharacterListUseCase
import kotlinx.coroutines.launch

class CharacterViewModel(private val characterListUseCase : CharacterListUseCase): ViewModel() {

    private val _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>> get() = _characterList

    private var _messageError = MutableLiveData<String>()
    val messageError: LiveData<String> = _messageError

    init {
        getCharacter()
    }

    private fun getCharacter(){
        viewModelScope.launch{
            when(val result = characterListUseCase()){
                is Success ->  _characterList.value = result.list
                is Error ->  _messageError.value = result.error
            }

        }
    }


}