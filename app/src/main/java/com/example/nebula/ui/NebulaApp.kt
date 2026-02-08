package com.example.nebula.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nebula.logic.NebulaContainer
import com.example.nebula.ui.navigation.NebulaNavHost
import com.example.nebula.ui.navigation.bottomNavItems
import com.example.nebula.ui.viewmodel.RepoViewModel
import com.example.nebula.ui.viewmodel.SearchViewModel

@Composable
fun NebulaApp() {
    val navController = rememberNavController()
    val repoManager = NebulaContainer.repoManager
    val searchViewModel = SearchViewModel(repoManager)
    val repoViewModel = RepoViewModel(repoManager)

    Scaffold(
        containerColor = androidx.compose.material3.MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar {
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry.value?.destination?.route

                bottomNavItems.forEach { destination ->
                    NavigationBarItem(
                        selected = currentRoute == destination.route,
                        onClick = {
                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { androidx.compose.material3.Icon(destination.icon, destination.label) },
                        label = { androidx.compose.material3.Text(destination.label) }
                    )
                }
            }
        }
    ) { padding ->
        NebulaNavHost(
            navController = navController,
            searchViewModel = searchViewModel,
            repoViewModel = repoViewModel,
            modifier = Modifier.padding(padding)
        )
    }
}
