package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.model.Info
import com.example.rickandmortyapp.repository.datasource.CharacterDataSourceImp
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val dataSourceImp: CharacterDataSourceImp
) {

    fun getAllCharacters():List<CharactersModel> = dataSourceImp.getAllFirstsCharacters()
    fun getCharactersPerPage(page:Int):List<CharactersModel> = dataSourceImp.getCharactersPerPage(page)

}