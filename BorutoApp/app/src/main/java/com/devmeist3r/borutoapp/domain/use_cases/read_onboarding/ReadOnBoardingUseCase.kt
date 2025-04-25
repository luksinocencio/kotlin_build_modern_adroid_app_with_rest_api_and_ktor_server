package com.devmeist3r.borutoapp.domain.use_cases.read_onboarding

import kotlinx.coroutines.flow.*
import com.devmeist3r.borutoapp.data.repository.*

class ReadOnBoardingUseCase(
    private val repository: Repository,
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}
