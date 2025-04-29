package com.devmeist3r.borutoapp.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import com.devmeist3r.borutoapp.domain.model.Hero

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
}
