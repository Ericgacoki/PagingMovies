package com.ericg.pagingmovies.data

import com.ericg.pagingmovies.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET(Constants.END_POINT)
    suspend fun getPopularMovies(
        @Query("page") page: Int = 0,
        @Query("api_key") api_key: String = "",
    ): MovieResponse
}