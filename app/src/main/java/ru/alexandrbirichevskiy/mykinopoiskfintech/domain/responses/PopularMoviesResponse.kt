package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PopularMoviesResponse(
    val pagesCount: Int,
    val films: List<FilmResponse>
)

@JsonClass(generateAdapter = true)
data class FilmResponse(
    val filmId: Long,
    val nameRu: String?,
    val nameEn: String?,
    val year: String?,
    val genres: List<GenreResponse>?,
    val posterUrlPreview: String?,
)

@JsonClass(generateAdapter = true)
data class GenreResponse(
    val genre: String?
)
