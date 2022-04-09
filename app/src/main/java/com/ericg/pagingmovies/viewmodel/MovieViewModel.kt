package com.ericg.pagingmovies.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ericg.pagingmovies.data.Movie
import com.ericg.pagingmovies.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {
    private var _movies = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val movies: State<Flow<PagingData<Movie>>> = _movies

    init {
        getMovies()
    }

    private fun getMovies(){
        viewModelScope.launch {
            _movies.value = repository.getPopularMovies().cachedIn(viewModelScope)
        }
    }
}