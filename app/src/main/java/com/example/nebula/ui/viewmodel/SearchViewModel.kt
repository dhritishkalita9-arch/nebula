package com.example.nebula.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.nebula.data.SearchResult
import com.example.nebula.logic.RepoManager

class SearchViewModel(private val repoManager: RepoManager) : ViewModel() {
    var query by mutableStateOf("")
        private set

    var results by mutableStateOf<List<SearchResult>>(emptyList())
        private set

    val extensions = repoManager.installedExtensions

    fun onQueryChange(newQuery: String) {
        query = newQuery
    }

    fun runSearch() {
        results = repoManager.searchAll(query)
    }
}
