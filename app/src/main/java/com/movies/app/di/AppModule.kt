package com.movies.app.di

import com.movies.app.common.Constants
import com.movies.app.data.remote.MovieDbApi
import com.movies.app.data.repository.MostPopularMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieDbApi(): MovieDbApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDbApi::class.java)

    }

    @Provides
    @Singleton
    fun provideMostPopularMoviesRepository(api: MovieDbApi): MostPopularMoviesRepository {
        return MostPopularMoviesRepository(api)
    }
 }