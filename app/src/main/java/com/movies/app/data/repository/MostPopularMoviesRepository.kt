package com.movies.app.data.repository

import com.movies.app.data.remote.MovieDbApi
import com.movies.app.data.remote.dto.MostPopularMoviesDto
import javax.inject.Inject

class MostPopularMoviesRepository @Inject constructor(
    private val api: MovieDbApi
) {
    suspend fun getMostPopularMovies(): MostPopularMoviesDto {
        return api.getMostPopularMovies()
    }
}