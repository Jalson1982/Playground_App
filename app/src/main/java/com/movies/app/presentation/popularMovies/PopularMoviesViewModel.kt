package com.movies.app.presentation.popularMovies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.app.common.Resource
import com.movies.app.data.remote.dto.MostPopularMoviesDto
import com.movies.app.data.repository.MostPopularMoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getMostPopularMovies: MostPopularMoviesRepository,
) : ViewModel() {
    private val _state = mutableStateOf(PopularMoviesState())
    val state: State<PopularMoviesState> = _state

    init {
        getMovies().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PopularMoviesState(movies = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        PopularMoviesState(error = result.message ?: "An unexprected error occured")
                }
                is Resource.Loading -> {
                    _state.value = PopularMoviesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMovies(): Flow<Resource<MostPopularMoviesDto>> = flow {
        try {
            emit(Resource.Loading<MostPopularMoviesDto>())
            val movies = getMostPopularMovies.getMostPopularMovies()
            emit(Resource.Success<MostPopularMoviesDto>(movies))
        } catch (e: HttpException) {
            emit(
                Resource.Error<MostPopularMoviesDto>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<MostPopularMoviesDto>("Could not reach server. Check your internet connection"))
        }
    }
}