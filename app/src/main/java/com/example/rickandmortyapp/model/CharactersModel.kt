package com.example.rickandmortyapp.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersModel(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("status") val status:String,
    @SerializedName("species") val species:String,
    @SerializedName("gender") val gender:String,
    @SerializedName("image") val image:String
)