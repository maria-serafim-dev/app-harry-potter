package com.example.appharrypotter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appharrypotter.network.HarryPotterApiRetrofit
import kotlinx.coroutines.launch
import com.example.appharrypotter.model.Character

class CharacterViewModel : ViewModel() {

    private val _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>> get() = _characterList

    init {
        getCharacter()
    }

    private fun getCharacter(){
        viewModelScope.launch{
            _characterList.value = HarryPotterApiRetrofit.retrofitService.getCharacter()
        }
    }


}