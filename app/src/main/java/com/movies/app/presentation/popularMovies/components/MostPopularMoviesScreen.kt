package com.movies.app.presentation.popularMovies.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.movies.app.common.Constants
import com.movies.app.presentation.popularMovies.PopularMoviesViewModel

@Composable
fun MostPopularMoviesScreen(
    viewModel: PopularMoviesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        state.movies?.let {
            items(it.results) { movie ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 5.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(550.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter("${Constants.IMAGE_PATH}${movie.posterPath}"),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.Crop,
                        )
                        GradientOverlay()
                        MovieDescription(title = movie.originalTitle, overview = movie.overview , releaseDate = movie.releaseDate )
                    }
                }
            }
        }
    }
}