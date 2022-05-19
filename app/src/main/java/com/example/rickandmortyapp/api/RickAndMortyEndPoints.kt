package com.example.rickandmortyapp.api

import com.example.rickandmortyapp.model.RickAndMortyResponse
import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyEndPoints {
    @GET("character")
    fun getCharacters():Call<RickAndMortyResponse>
}