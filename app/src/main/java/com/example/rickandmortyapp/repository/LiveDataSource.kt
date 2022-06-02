package com.example.rickandmortyapp.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PositionalDataSource

class LiveDataSource<T>(private val items: List<T>) : DataSource.Factory<Int, T>() {
    val sourceLiveData = MutableLiveData<FakeDataSource<T>>()

    override fun create(): DataSource<Int, T> {
        val source = FakeDataSource(items)
        sourceLiveData.postValue(source)
        return source
    }


    class FakeDataSource<T>(var items: List<T>) : PositionalDataSource<T>() {
        override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<T>) {
            val totalCount = items.size

            val position = PositionalDataSource.computeInitialLoadPosition(params, totalCount)
            val loadSize = PositionalDataSource.computeInitialLoadSize(params, position, totalCount)

            val subList = items.subList(position, position + loadSize)

            callback.onResult(subList, position, totalCount)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<T>) {
            callback.onResult(items.subList(params.startPosition,
                params.startPosition + params.loadSize))
        }

    }
}