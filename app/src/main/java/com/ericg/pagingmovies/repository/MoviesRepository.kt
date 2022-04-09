package com.ericg.pagingmovies.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ericg.pagingmovies.data.APIService
import com.ericg.pagingmovies.data.Movie
import com.ericg.pagingmovies.data.pagingSource.MoviePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepository @Inject constructor(val api: APIService) {
    fun getPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                MoviePagingSource(api = api)
            }
        ).flow
    }
}