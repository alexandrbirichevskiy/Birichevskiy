package ru.alexandrbirichevskiy.mykinopoiskfintech.extensions

import androidx.compose.ui.text.capitalize
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.PopularMoviesModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.FilmResponse
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.GenreResponse
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.responses.PopularMoviesResponse

fun PopularMoviesResponse.toModelMapper(): PopularMoviesModel {
    return PopularMoviesModel(
        pagesCount = this.pagesCount,
        movies = this.films.map {
            it.toModelMapper()
        }
    )
}

fun FilmResponse.toModelMapper(): MovieModel {
    return MovieModel(
        movieId = this.filmId,
        name = this.nameRu.orDefault(this.nameEn.orDefault()),
        year = this.year.orDefault(),
        genre = if (this.genres != null) {
            this.genres[0].toModelMapper()
        } else {
            "Неизвестно"
        },
        url = this.posterUrlPreview.orDefault("")
    )
}

fun GenreResponse.toModelMapper(): String {
    return this.genre.orDefault().replaceFirstChar { char -> char.uppercase() }
}