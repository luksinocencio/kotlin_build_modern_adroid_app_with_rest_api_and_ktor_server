package com.devmeist3r.borutoapp.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.devmeist3r.borutoapp.domain.model.Hero
import com.devmeist3r.borutoapp.domain.repository.DataStoreOperations
import com.devmeist3r.borutoapp.domain.repository.RemoteDataSource


class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

}
