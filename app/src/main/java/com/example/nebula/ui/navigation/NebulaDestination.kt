package com.example.nebula.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NebulaDestination(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    data object Home : NebulaDestination("home", "Home", Icons.Filled.Home)
    data object Search : NebulaDestination("search", "Search", Icons.Filled.Search)
    data object Repos : NebulaDestination("repos", "Repos", Icons.Filled.Storage)
}

val bottomNavItems = listOf(
    NebulaDestination.Home,
    NebulaDestination.Search,
    NebulaDestination.Repos
)
