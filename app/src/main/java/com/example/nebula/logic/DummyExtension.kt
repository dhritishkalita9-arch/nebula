package com.example.nebula.logic

import com.example.nebula.data.ExtensionInfo
import com.example.nebula.data.MediaItem
import com.example.nebula.domain.ExtensionApi

/**
 * A mock extension that returns local, fake data.
 * This proves the extension system works without requiring any real sources.
 */
class DummyExtension : ExtensionApi {
    val info = ExtensionInfo(
        id = "dummy-extension",
        name = "Nebula Demo Extension",
        version = "1.0.0"
    )

    private val catalog = listOf(
        MediaItem(
            id = "mock-1",
            title = "Orbital Echoes",
            description = "A calming ambient playlist that demonstrates mock data."
        ),
        MediaItem(
            id = "mock-2",
            title = "Signal Drift",
            description = "A sci-fi podcast series about explorers mapping a new galaxy."
        ),
        MediaItem(
            id = "mock-3",
            title = "Lumen Stories",
            description = "Short-form stories designed for a warm evening listen."
        )
    )

    override fun search(query: String): List<MediaItem> {
        if (query.isBlank()) return emptyList()
        return catalog.filter {
            it.title.contains(query, ignoreCase = true) ||
                it.description.contains(query, ignoreCase = true)
        }
    }

    override fun getDetails(id: String): MediaItem {
        return catalog.firstOrNull { it.id == id }
            ?: MediaItem(id = id, title = "Unknown", description = "No details available.")
    }
}
