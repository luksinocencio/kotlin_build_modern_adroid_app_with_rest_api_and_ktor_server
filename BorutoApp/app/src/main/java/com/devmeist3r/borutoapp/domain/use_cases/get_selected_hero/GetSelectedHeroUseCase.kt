package com.devmeist3r.borutoapp.domain.use_cases.get_selected_hero

import com.devmeist3r.borutoapp.data.repository.Repository
import com.devmeist3r.borutoapp.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}
