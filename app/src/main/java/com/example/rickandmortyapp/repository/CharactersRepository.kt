package com.example.rickandmortyapp.repository

import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.model.Info
import com.example.rickandmortyapp.repository.datasource.CharacterDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val dataSourceImp: CharacterDataSourceImp
) {

    fun getAllCharacters():List<CharactersModel> = dataSourceImp.getAllCharacters()
    fun getInfoAboutPage():Info{
        return try {
            dataSourceImp.getInfoAboutCall()
        }catch (ex:Exception){
            ex.printStackTrace()
            Info(0, 0, "", "")
        }
    }

}