package com.movies.app.data.remote

import com.movies.app.common.Constants
import com.movies.app.data.remote.dto.MostPopularMoviesDto
import retrofit2.http.GET

interface MovieDbApi {
    @GET("/3/movie/popular?api_key=${Constants.API_KEY}&language=en-US")
    suspend fun getMostPopularMovies(): MostPopularMoviesDto
}