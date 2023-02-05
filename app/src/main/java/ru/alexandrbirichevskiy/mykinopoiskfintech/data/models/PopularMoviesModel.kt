package ru.alexandrbirichevskiy.mykinopoiskfintech.data.models

data class PopularMoviesModel(
    val pagesCount: Int,
    val movies: List<MovieModel>
)

data class MovieModel(
    val movieId: Long,
    val name: String,
    val year: String,
    val genre: String,
    val url: String,
)
