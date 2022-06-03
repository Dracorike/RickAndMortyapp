package com.example.rickandmortyapp.repository.datasource

import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.model.Info
import com.example.rickandmortyapp.model.RickAndMortyResponse

interface ChacterDataSource {
    fun getAllFirstsCharacters(): List<CharactersModel>
    fun getCharactersPerPage(page: Int): List<CharactersModel>
}