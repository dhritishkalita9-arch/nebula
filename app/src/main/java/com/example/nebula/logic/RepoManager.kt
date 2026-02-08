package com.example.nebula.logic

import androidx.compose.runtime.mutableStateListOf
import com.example.nebula.data.Repo
import com.example.nebula.data.SearchResult

/**
 * In-memory repo manager that keeps track of user-added repos and installed extensions.
 * No network calls are made; this only uses mock data.
 */
class RepoManager {
    val repos = mutableStateListOf<Repo>()
    val installedExtensions = mutableStateListOf<DummyExtension>()

    fun addRepo(url: String) {
        val trimmed = url.trim()
        if (trimmed.isBlank()) return
        val repoName = trimmed.substringAfterLast('/').ifBlank { "Custom Repo" }
        repos.add(Repo(name = repoName, url = trimmed))

        // Demo-only behavior: when a repo is added, we "discover" a mock extension.
        if (installedExtensions.isEmpty()) {
            installedExtensions.add(DummyExtension())
        }
    }

    fun searchAll(query: String): List<SearchResult> {
        return installedExtensions.flatMap { extension ->
            extension.search(query).map { item ->
                SearchResult(item = item, extension = extension.info)
            }
        }
    }
}
