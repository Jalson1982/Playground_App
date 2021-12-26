package com.movies.app.presentation.popularMovies

import com.movies.app.data.remote.dto.MostPopularMoviesDto

data class PopularMoviesState(
    val isLoading: Boolean = false,
    val movies: MostPopularMoviesDto? = null,
    val error: String = ""
)
