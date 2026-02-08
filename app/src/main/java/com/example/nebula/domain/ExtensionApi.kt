package com.example.nebula.domain

import com.example.nebula.data.MediaItem

/**
 * Contract that all extensions must implement.
 */
interface ExtensionApi {
    fun search(query: String): List<MediaItem>

    fun getDetails(id: String): MediaItem
}
