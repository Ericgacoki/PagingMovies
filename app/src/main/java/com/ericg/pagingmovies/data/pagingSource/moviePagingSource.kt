package com.ericg.pagingmovies.data.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ericg.pagingmovies.data.APIService
import com.ericg.pagingmovies.data.Movie

class MoviePagingSource(private val api: APIService) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage: Int = params.key ?: 1
            val popularMovies = api.getPopularMovies(page = nextPage)

            LoadResult.Page(
                data = popularMovies.movies,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (popularMovies.movies.isEmpty()) null else popularMovies.page + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}