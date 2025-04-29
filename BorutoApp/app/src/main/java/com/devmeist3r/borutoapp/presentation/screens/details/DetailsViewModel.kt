package com.devmeist3r.borutoapp.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import android.util.Log
import com.devmeist3r.borutoapp.domain.model.Hero
import com.devmeist3r.borutoapp.domain.use_cases.UseCases
import com.devmeist3r.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val usesCases: UseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _selecedHero: MutableState<Hero?> = mutableStateOf(null)
    val selectedHero: State<Hero?> = _selecedHero

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val heroId = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _selecedHero.value = heroId?.let { usesCases.getSelectedHeroUseCase(heroId = heroId) }

            // Log the selected hero name
            _selecedHero.value?.name.let { Log.d("Hero", it.toString()) }
        }
    }
}
