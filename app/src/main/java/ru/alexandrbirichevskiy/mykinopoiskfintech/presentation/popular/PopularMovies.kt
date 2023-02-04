package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation.popular

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PopularMovies(
    viewModel: PopularMoviesViewModel = hiltViewModel()
) {
    Text(text = "Popular Movies")
}