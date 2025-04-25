package com.devmeist3r.borutoapp.domain.use_cases

import com.devmeist3r.borutoapp.domain.use_cases.read_onboarding.*
import com.devmeist3r.borutoapp.domain.use_cases.save_onboarding.*

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
)
