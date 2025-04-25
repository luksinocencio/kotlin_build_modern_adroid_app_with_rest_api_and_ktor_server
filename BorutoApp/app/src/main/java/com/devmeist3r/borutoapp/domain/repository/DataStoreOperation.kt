package com.devmeist3r.borutoapp.domain.repository

import kotlinx.coroutines.flow.*

interface DataStoreOperation {
    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}
