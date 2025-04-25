package com.devmeist3r.borutoapp.presentation.screens.splahscreen

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*
import com.devmeist3r.borutoapp.domain.use_cases.*

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {
    private val _onBoardingCompleted = MutableStateFlow(false)
    val onBoardingCompleted: StateFlow<Boolean> = _onBoardingCompleted

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _onBoardingCompleted.value = useCases.readOnBoardingUseCase().stateIn(viewModelScope).value
        }
    }
}
