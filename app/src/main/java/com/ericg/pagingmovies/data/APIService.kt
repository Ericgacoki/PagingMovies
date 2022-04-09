package com.ericg.pagingmovies.data

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String = "",
        @Query("page") page: Int = 0,
    ): MovieResponse
}