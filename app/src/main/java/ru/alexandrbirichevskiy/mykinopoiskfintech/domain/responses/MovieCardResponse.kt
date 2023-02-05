package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieCardResponse(
    val kinopoiskId: Long,
    val nameRu: String?,
    val nameEn: String?,
    val posterUrl: String?,
    val description: String?,
    val countries: List<CountryResponse>?,
    val genres: List<GenreResponse>?
)

@JsonClass(generateAdapter = true)
data class CountryResponse(
    val country: String?
)