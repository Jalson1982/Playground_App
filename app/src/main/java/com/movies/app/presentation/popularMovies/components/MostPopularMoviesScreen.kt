package com.movies.app.presentation.popularMovies.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.movies.app.presentation.popularMovies.PopularMoviesViewModel

@Composable
fun MostPopularMoviesScreen(
    viewModel: PopularMoviesViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            state.movies?.let { items(it.results) { movie ->
                Text(text = movie.originalTitle)
                
            } }
        }
    }
}