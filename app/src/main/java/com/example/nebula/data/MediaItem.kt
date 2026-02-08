package com.example.nebula.data

/**
 * Represents a piece of media returned by an extension.
 * The optional [poster] can point to a local resource or a remote URL in real apps.
 */
data class MediaItem(
    val id: String,
    val title: String,
    val description: String,
    val poster: String? = null
)
