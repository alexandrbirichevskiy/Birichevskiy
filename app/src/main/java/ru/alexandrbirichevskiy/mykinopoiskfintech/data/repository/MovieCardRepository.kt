package ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository

import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieCardModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.api.MovieCardApi
import ru.alexandrbirichevskiy.mykinopoiskfintech.extensions.toMovieCardModel


interface MovieCardRepository {
    suspend fun getMovieCard(movieId: Long): MovieCardModel
}

class MovieCardRepositoryImpl(
    private val api: MovieCardApi
) : MovieCardRepository {

    override suspend fun getMovieCard(movieId: Long): MovieCardModel {
        val response = api.getMovieCard(movieId)
        if (response.isSuccessful) {
            return response.body()?.toMovieCardModel() ?: error("")
        } else {
            error("")
        }
    }
}