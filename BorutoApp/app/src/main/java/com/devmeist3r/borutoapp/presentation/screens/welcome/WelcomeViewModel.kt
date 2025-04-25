package com.devmeist3r.borutoapp.presentation.screens.welcome

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.*
import kotlinx.coroutines.*
import javax.inject.*
import com.devmeist3r.borutoapp.domain.use_cases.*

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {
    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.saveOnBoardingUseCase(completed = completed)
        }
    }
}
