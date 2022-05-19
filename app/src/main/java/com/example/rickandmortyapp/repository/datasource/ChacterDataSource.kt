package com.example.rickandmortyapp.repository.datasource

import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.model.RickAndMortyResponse

interface ChacterDataSource {
    fun getAllCharacters():List<CharactersModel>
}