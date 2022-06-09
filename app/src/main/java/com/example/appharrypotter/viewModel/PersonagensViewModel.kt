package com.example.appharrypotter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appharrypotter.model.Personagem
import com.example.appharrypotter.network.HarryPotterApiRetrofit
import kotlinx.coroutines.launch

class PersonagensViewModel : ViewModel() {

    private val _listaPersonagens = MutableLiveData<List<Personagem>>()
    val listaPersonagens: LiveData<List<Personagem>> get() = _listaPersonagens

    private fun getFilmes(){
        viewModelScope.launch{
            _listaPersonagens.value = HarryPotterApiRetrofit.retrofitService.getPersonagens()
        }
    }

    init {
        getFilmes()
    }
}