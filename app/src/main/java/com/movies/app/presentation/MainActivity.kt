package com.movies.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.movies.app.presentation.popularMovies.components.MostPopularMoviesScreen
import com.movies.app.presentation.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MostPopularMoviesScreen()
                }
            }
        }
    }
}
