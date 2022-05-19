package com.example.rickandmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.repository.CharactersRepository
import com.example.rickandmortyapp.utils.ERROR_VIEW_MODEL_CALL_ALLCHARACTERS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfCharactersViewModel @Inject constructor(
    private val repository: CharactersRepository
):ViewModel() {
    private var _listOfCharacters = MutableLiveData<List<CharactersModel>>()
    val listOfCharacter:LiveData<List<CharactersModel>> get() = _listOfCharacters

    fun initViewModel(){
        getListWithAllCharacters()
    }

    private fun getListWithAllCharacters(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val listCharacters = repository.getAllCharacters()
                _listOfCharacters.postValue(listCharacters)
            }catch (ex:Exception){
                Log.e(ERROR_VIEW_MODEL_CALL_ALLCHARACTERS, "Houve algum erro ao chamar o callback", ex)
                ex.printStackTrace()
            }
        }
    }

}