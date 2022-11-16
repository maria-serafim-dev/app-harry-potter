package com.example.appharrypotter.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appharrypotter.core.Result.Error
import com.example.appharrypotter.core.Result.Success
import com.example.appharrypotter.core.State
import com.example.appharrypotter.domain.model.CharacterDomain
import com.example.appharrypotter.domain.useCase.CharacterListUseCase
import kotlinx.coroutines.launch

class CharacterViewModel(private val characterListUseCase : CharacterListUseCase): ViewModel() {

    private val _characterList = MutableLiveData<List<CharacterDomain>>()
    val characterList: LiveData<List<CharacterDomain>> get() = _characterList

    private var _messageError = MutableLiveData<String>()
    val messageError: LiveData<String> = _messageError

    private var _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewModelScope.launch {
            when (val result = characterListUseCase()) {
                is Success -> {
                    if (result.list.isEmpty()) _state.value = State.EMPTY
                    else {
                        _characterList.value = result.list
                        _state.value = State.SUCCESS
                    }
                }
                is Error -> {
                    _messageError.value = result.error
                    _state.value = State.ERROR
                }
            }

        }
    }
}