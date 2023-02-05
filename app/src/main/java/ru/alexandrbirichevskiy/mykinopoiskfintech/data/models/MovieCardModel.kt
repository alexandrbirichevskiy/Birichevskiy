package ru.alexandrbirichevskiy.mykinopoiskfintech.data.models

data class MovieCardModel(
    val id: Long,
    val name: String,
    val url: String,
    val description: String,
    val countries: List<String>,
    val genres: List<String>
)
