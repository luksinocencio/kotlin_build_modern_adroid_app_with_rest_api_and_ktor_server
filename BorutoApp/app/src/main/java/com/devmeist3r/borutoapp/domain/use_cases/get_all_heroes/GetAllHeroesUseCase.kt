package com.devmeist3r.borutoapp.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import com.devmeist3r.borutoapp.data.repository.Repository
import com.devmeist3r.borutoapp.domain.model.Hero

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}
