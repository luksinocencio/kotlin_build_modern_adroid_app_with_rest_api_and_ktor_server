package com.devmeist3r.borutoapp.data.repository

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.devmeist3r.borutoapp.domain.repository.DataStoreOperations


class Repository @Inject constructor(
    private val dataStore: DataStoreOperations,
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}
