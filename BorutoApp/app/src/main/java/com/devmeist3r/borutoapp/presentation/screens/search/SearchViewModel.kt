package com.devmeist3r.borutoapp.presentation.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
}
