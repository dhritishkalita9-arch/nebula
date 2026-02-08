package com.example.nebula.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nebula.ui.screens.HomeScreen
import com.example.nebula.ui.screens.RepoScreen
import com.example.nebula.ui.screens.SearchScreen
import com.example.nebula.ui.viewmodel.RepoViewModel
import com.example.nebula.ui.viewmodel.SearchViewModel

@Composable
fun NebulaNavHost(
    navController: NavHostController,
    searchViewModel: SearchViewModel,
    repoViewModel: RepoViewModel,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NebulaDestination.Home.route,
        modifier = modifier
    ) {
        composable(NebulaDestination.Home.route) {
            HomeScreen()
        }
        composable(NebulaDestination.Search.route) {
            SearchScreen(searchViewModel = searchViewModel)
        }
        composable(NebulaDestination.Repos.route) {
            RepoScreen(repoViewModel = repoViewModel)
        }
    }
}
