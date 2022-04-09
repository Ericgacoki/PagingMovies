package com.ericg.pagingmovies.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.ericg.pagingmovies.viewmodel.MovieViewModel

@Composable
fun MoviesList() {

    val viewModel: MovieViewModel = hiltViewModel()
    val movieItems = viewModel.movies.value.collectAsLazyPagingItems()

    LazyColumn() {
        items(movieItems) { movie ->
            if (movie != null) {
                MovieItem(movie = movie)
            }
        }
    }

}