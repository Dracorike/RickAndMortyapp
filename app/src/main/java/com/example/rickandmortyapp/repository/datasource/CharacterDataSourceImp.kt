package com.example.rickandmortyapp.repository.datasource

import android.util.Log
import com.example.rickandmortyapp.api.RickAndMortyApi
import com.example.rickandmortyapp.api.RickAndMortyEndPoints
import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.utils.CALLBACK_ERROR_ALL_CHARACTERS
import javax.inject.Inject

class CharacterDataSourceImp @Inject constructor(
    private val callApi: RickAndMortyEndPoints
): ChacterDataSource {
    override fun getAllCharacters(): List<CharactersModel> {
        val response = arrayListOf<CharactersModel>()
        try {
            response.addAll(callApiAllCharacters())
        } catch (ex: Exception) {
            Log.e(CALLBACK_ERROR_ALL_CHARACTERS, "CHARACTER_ALL_ERROR")
        }

        return response
    }

    private fun callApiAllCharacters(): List<CharactersModel> {
        val response = callApi.getCharacters().execute()
        return if (response.isSuccessful) {
            response.body()?.result ?: emptyList()
        } else {
            throw Exception()
        }
    }
}