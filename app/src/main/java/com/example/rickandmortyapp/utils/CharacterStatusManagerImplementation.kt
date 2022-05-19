package com.example.rickandmortyapp.utils

import com.example.rickandmortyapp.R

class CharacterStatusManagerImplementation:CharacterStatusManager {
    override fun getCharacterStatusIcon(status:String): Int {
        return when(status){
            "DEAD" -> R.drawable.status_value_icon_dead
            "ALIVE" -> R.drawable.status_value_icon_alive
            "UNKNOWN" -> R.drawable.status_value_icon_unknown
            else -> 0
        }
    }
}