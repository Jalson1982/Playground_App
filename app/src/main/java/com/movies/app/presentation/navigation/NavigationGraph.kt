package com.movies.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.movies.app.presentation.favourites.Favourites
import com.movies.app.presentation.navigation.bottom_navigator.BottomNavItem
import com.movies.app.presentation.popularMovies.components.MostPopularMoviesScreen
import com.movies.app.presentation.series.Series

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            MostPopularMoviesScreen()
        }
        composable(BottomNavItem.Favourites.screen_route) {
            Favourites()
        }
        composable(BottomNavItem.Series.screen_route) {
            Series()
        }
    }
}