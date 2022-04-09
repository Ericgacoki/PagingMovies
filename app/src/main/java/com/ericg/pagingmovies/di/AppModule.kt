package com.ericg.pagingmovies.di

import com.ericg.pagingmovies.data.APIService
import com.ericg.pagingmovies.repository.MoviesRepository
import com.ericg.pagingmovies.util.Constants
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
    @Singleton
    @Provides
    fun provideAPI(): APIService{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

    @Singleton
    @Provides
    fun providesMoviesRepository(api: APIService)
    = MoviesRepository(api)
}