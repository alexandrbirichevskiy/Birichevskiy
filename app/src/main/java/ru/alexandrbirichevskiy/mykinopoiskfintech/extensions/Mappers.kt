package ru.alexandrbirichevskiy.mykinopoiskfintech.extensions

import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieCardModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.FilmResponse
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.GenreResponse
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.MovieCardResponse

fun FilmResponse.toMovieModel(): MovieModel {
    return MovieModel(
        movieId = this.filmId,
        name = this.nameRu.orDefault(this.nameEn.orDefault()),
        year = this.year.orDefault(),
        genre = if (this.genres != null) {
            this.genres[0].toStringModel()
        } else {
            "Неизвестно"
        },
        url = this.posterUrlPreview.orDefault("")
    )
}

fun GenreResponse.toStringModel(): String {
    return this.genre.orDefault().replaceFirstChar { char -> char.uppercase() }
}

fun MovieCardResponse.toMovieCardModel(): MovieCardModel {
    return MovieCardModel(
        id = this.kinopoiskId,
        name = this.nameRu.orDefault(this.nameEn.orDefault()),
        url = this.posterUrl.orDefault(""),
        description = this.description.orDefault(),
        countries = this.countries?.map {
            it.country.toString()
        } ?: listOf(),
        genres = this.genres?.map {
            it.genre.toString()
        } ?: listOf()
    )
}