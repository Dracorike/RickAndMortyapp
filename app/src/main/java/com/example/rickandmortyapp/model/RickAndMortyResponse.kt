package com.example.rickandmortyapp.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RickAndMortyResponse (
    @SerializedName("info") val info:Info,
    @SerializedName("results") val result:List<CharactersModel>
)

