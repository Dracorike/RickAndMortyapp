package com.example.rickandmortyapp.api

import com.example.rickandmortyapp.model.RickAndMortyResponse
import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyEndPoints {
    @GET("character")
    fun getCharacters(): Call<RickAndMortyResponse>

    @GET("character")
    fun getCharacterPerPage(@Query("page") page: Int): Call<RickAndMortyResponse>
}