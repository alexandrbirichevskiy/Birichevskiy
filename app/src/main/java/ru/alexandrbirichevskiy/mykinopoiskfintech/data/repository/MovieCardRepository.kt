package ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository

import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.MovieCardModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.ConnectionState
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.network.api.MovieCardApi
import ru.alexandrbirichevskiy.mykinopoiskfintech.extensions.toMovieCardModel


interface MovieCardRepository {
    suspend fun getMovieCard(movieId: Long): Pair<MovieCardModel?, Int?>
}

class MovieCardRepositoryImpl(
    private val api: MovieCardApi,
    private val connectionState: ConnectionState
) : MovieCardRepository {

    override suspend fun getMovieCard(movieId: Long): Pair<MovieCardModel?, Int?> {
        return if (connectionState.connectionState.value) {
            val response = api.getMovieCard(movieId)
            if (response.isSuccessful) {
                if (response.body() != null) {
                    Pair(response.body()!!.toMovieCardModel(), response.code())
                } else {
                    Pair(null, response.code())
                }
            } else {
                Pair(null, response.code())
            }
        } else {
            Pair(null, null)
        }
    }
}