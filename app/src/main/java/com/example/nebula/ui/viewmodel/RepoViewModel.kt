package com.example.nebula.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nebula.logic.RepoManager

class RepoViewModel(private val repoManager: RepoManager) : ViewModel() {
    val repos = repoManager.repos

    fun addRepo(url: String) {
        repoManager.addRepo(url)
    }
}
