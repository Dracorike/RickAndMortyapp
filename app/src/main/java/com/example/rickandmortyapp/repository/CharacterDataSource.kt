package com.example.rickandmortyapp.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.ItemKeyedDataSource
import com.example.rickandmortyapp.model.CharactersModel
import javax.inject.Inject

class CharacterDataSource @Inject constructor(
    private val items: CharactersRepository
) : DataSource.Factory<Int, CharactersModel>() {
    private val sourceLiveData = MutableLiveData<DataSourcePersons>()
    override fun create(): DataSource<Int, CharactersModel> {
        val source = DataSourcePersons(items)
        sourceLiveData.postValue(source)
        return source
    }


    class DataSourcePersons(
        private val items: CharactersRepository
    ) : ItemKeyedDataSource<Int, CharactersModel>() {
        override fun getKey(item: CharactersModel): Int = 0
        private var nextKey = 1

        override fun loadInitial(
            params: LoadInitialParams<Int>,
            callback: LoadInitialCallback<CharactersModel>
        ) {
            Thread {
                val list = items.getAllCharacters()
                callback.onResult(list)
            }.start()
        }

        override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<CharactersModel>) {
            Thread {
                nextKey +=1
                val otherList = items.getCharactersPerPage(nextKey)
                callback.onResult(otherList)
            }.start()
        }

        override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<CharactersModel>) {

        }

    }
}