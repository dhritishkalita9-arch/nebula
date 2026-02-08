package com.example.nebula.data

/**
 * Combines a media item with the extension that returned it.
 */
data class SearchResult(
    val item: MediaItem,
    val extension: ExtensionInfo
)
