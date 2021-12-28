package com.movies.app.presentation

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.movies.app.presentation.navigation.NavigationGraph
import com.movies.app.presentation.navigation.bottom_navigator.BottomNavigator
import com.movies.app.presentation.popularMovies.components.MostPopularMoviesScreen
import com.movies.app.presentation.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            MoviesAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigator(navController = navController) }
                ) {

                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}
