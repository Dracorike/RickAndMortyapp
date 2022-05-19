package com.example.rickandmortyapp.utils

class CharacterInformationUtils(
    private val characterStatusManager: CharacterStatusManager
) {
    fun getCharacterStatusIcon(status:String):Int{
        return characterStatusManager.getCharacterStatusIcon(status)
    }
}