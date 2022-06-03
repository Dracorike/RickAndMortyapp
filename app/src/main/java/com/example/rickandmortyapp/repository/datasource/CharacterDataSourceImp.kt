package com.example.rickandmortyapp.repository.datasource

import android.util.Log
import com.example.rickandmortyapp.api.RickAndMortyEndPoints
import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.model.Info
import com.example.rickandmortyapp.utils.CALLBACK_ERROR_ALL_CHARACTERS
import com.example.rickandmortyapp.utils.CALLBACK_ERROR_INFO_ABOUT_PAGE
import com.example.rickandmortyapp.utils.CALLBACK_SUCCESS_GET_CHARACTER_PER_PAGE
import com.example.rickandmortyapp.utils.CALL_BACK_ERROR_GET_CHARACTER_PER_PAGE
import java.lang.NullPointerException
import javax.inject.Inject

class CharacterDataSourceImp @Inject constructor(
    private val callApi: RickAndMortyEndPoints
) : ChacterDataSource {
    override fun getAllFirstsCharacters(): List<CharactersModel> {
        val response = arrayListOf<CharactersModel>()
        try {
            response.addAll(callApiAllCharacters())
        } catch (ex: Exception) {
            Log.e(CALLBACK_ERROR_ALL_CHARACTERS, "CHARACTER_ALL_ERROR")
        }

        return response
    }



    override fun getCharactersPerPage(page: Int): List<CharactersModel> {
        val listOfPersons = arrayListOf<CharactersModel>()
        try {
            val response = callApi.getCharacterPerPage(page).execute()
            if (response.isSuccessful) {
                listOfPersons.addAll(response.body()?.result.orEmpty())
                Log.i(CALLBACK_SUCCESS_GET_CHARACTER_PER_PAGE, "Sucesso ao resgatar lista!")
            } else {
                Log.e(CALL_BACK_ERROR_GET_CHARACTER_PER_PAGE, response.errorBody().toString())
            }
        } catch (ex: Exception) {
            Log.e(CALL_BACK_ERROR_GET_CHARACTER_PER_PAGE, ex.toString())
            ex.printStackTrace()
        }
        return listOfPersons
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