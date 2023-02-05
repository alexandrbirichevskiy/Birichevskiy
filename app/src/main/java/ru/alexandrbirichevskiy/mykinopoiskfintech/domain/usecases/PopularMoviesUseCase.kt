package ru.alexandrbirichevskiy.mykinopoiskfintech.domain.usecases

import ru.alexandrbirichevskiy.mykinopoiskfintech.data.models.PopularMoviesModel
import ru.alexandrbirichevskiy.mykinopoiskfintech.data.repository.PopularMoviesRepository
import ru.alexandrbirichevskiy.mykinopoiskfintech.domain.PopularMoviesApi

interface PopularMoviesUseCase {
    suspend fun getPopularMovies(): PopularMoviesModel
}

class PopularMoviesUseCaseImpl(
    private val popularMoviesRepository: PopularMoviesRepository
) : PopularMoviesUseCase {
    override suspend fun getPopularMovies(): PopularMoviesModel {
        return popularMoviesRepository.getPopularMovies()
    }
}