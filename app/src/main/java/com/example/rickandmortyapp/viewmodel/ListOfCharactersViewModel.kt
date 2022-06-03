package com.example.rickandmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.repository.CharacterDataSource
import com.example.rickandmortyapp.repository.CharactersRepository
import com.example.rickandmortyapp.utils.ERROR_VIEW_MODEL_CALL_ALL_CHARACTERS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfCharactersViewModel @Inject constructor(
    private val repository: CharactersRepository,
    characterDataSource: CharacterDataSource
) : ViewModel() {
    private var _listOfCharacters = MutableLiveData<List<CharactersModel>>()
    val pagedList = LivePagedListBuilder(
        characterDataSource,
        PagedList.Config.Builder()
            .setPageSize(10)
            .setPrefetchDistance(10)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(true)
            .build()
    ).build()

    fun initViewModel() {
        getListWithAllCharacters()
    }

    private fun getListWithAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val listCharacters = repository.getAllCharacters()
                _listOfCharacters.postValue(listCharacters)
            } catch (ex: Exception) {
                Log.e(
                    ERROR_VIEW_MODEL_CALL_ALL_CHARACTERS,
                    "Houve algum erro ao chamar o callback",
                    ex
                )
                ex.printStackTrace()
            }
        }
    }

}