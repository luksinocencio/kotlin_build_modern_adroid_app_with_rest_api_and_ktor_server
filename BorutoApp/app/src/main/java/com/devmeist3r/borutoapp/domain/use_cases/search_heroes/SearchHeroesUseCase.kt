package com.devmeist3r.borutoapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import com.devmeist3r.borutoapp.data.repository.Repository
import com.devmeist3r.borutoapp.domain.model.Hero

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}
