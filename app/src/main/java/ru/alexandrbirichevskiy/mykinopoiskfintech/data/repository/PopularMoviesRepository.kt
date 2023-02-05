package ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository

import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.PopularMoviesModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.PopularMoviesApi
import ru.alexandrbirichevskiy.mykinopoiskfintech.extensions.toModelMapper

interface PopularMoviesRepository {
    suspend fun getPopularMovies(): PopularMoviesModel
}

class PopularMoviesRepositoryImpl(
    private val popularMoviesApi: PopularMoviesApi
) : PopularMoviesRepository {

    override suspend fun getPopularMovies(): PopularMoviesModel {
        return popularMoviesApi.getPopularMovies().body()!!.toModelMapper()
    }
}
