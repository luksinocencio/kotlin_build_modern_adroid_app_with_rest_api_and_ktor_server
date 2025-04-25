package com.devmeist3r.borutoapp.domain.use_cases.save_onboarding

import com.devmeist3r.borutoapp.data.repository.*

class SaveOnBoardingUseCase(
    private val repository: Repository,
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}
