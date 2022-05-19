package com.example.rickandmortyapp

import com.example.rickandmortyapp.utils.CharacterStatusEnum
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val toPrint = CharacterStatusEnum.DEAD.ordinal
        println(toPrint)
    }
}